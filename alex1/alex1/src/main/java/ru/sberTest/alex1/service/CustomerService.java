package ru.sberTest.alex1.service;

import java.math.BigDecimal;

public interface CustomerService {
    /**
     * Метод добавит пользователю поинтов
     *
     * @param customerId id
     * @param points     количество поинтов
     */
    void addPoints(Long customerId, BigDecimal points);

    /**
     * Метод вычтет у пользователя поинты
     *
     * @param customerId id
     * @param points     количество поинтов
     */
    void deductPoints(Long customerId, BigDecimal points);

    /**
     *
     * @param customerId
     * @return метод возвращает баланс пользователя
     */
    BigDecimal getPoints(Long customerId);
}

