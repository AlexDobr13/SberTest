package ru.sberTest.alex1.persist.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.sberTest.alex1.persist.entity.CustomerEntity;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByCustomerId(Long customerId);
}
