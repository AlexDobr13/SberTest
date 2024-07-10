package ru.sberTest.alex1.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sberTest.alex1.persist.entity.CustomerEntity;
import ru.sberTest.alex1.persist.repository.CustomerRepository;

import java.math.BigDecimal;
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Transactional
    @Override
    public void addPoints(@NonNull Long customerId, @NonNull BigDecimal points) {
        var customerPoints = customerRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        customerPoints.setCustomerId(customerId);
        customerPoints.setPoints(customerPoints.getPoints().add(points));
        customerRepository.save(customerPoints);

    }

    @Transactional
    @Override
    public void deductPoints(@NonNull Long customerId, @NonNull BigDecimal points) {
        var customerPoints = customerRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

        if (customerPoints.getPoints().compareTo(points) < 0) {
            throw new IllegalArgumentException("Недостаточно поинтов, нельзя допустить отрицительный баланс");
        }
        customerPoints.setPoints(customerPoints.getPoints().subtract(points));
        customerRepository.save(customerPoints);
    }

    @Transactional(readOnly = true)
    @Override
    public BigDecimal getPoints(@NonNull Long customerId) {
        return customerRepository
                .findByCustomerId(customerId)
                .map(CustomerEntity::getPoints)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
    }

}

