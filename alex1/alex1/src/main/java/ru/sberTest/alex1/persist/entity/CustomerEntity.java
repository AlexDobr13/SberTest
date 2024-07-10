package ru.sberTest.alex1.persist.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
@Table(name = "customer")
@Data
@Entity
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "points")
    private BigDecimal points;


}
