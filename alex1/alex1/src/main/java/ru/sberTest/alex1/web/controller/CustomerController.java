package ru.sberTest.alex1.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sberTest.alex1.service.CustomerServiceImpl;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/points")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerServiceImpl customerServiceImpl;

    @PostMapping("/add")
    public void addPoints(@RequestParam Long customerId, @RequestParam Long points) {
        customerServiceImpl.addPoints(customerId, BigDecimal.valueOf(points));
    }

    @PostMapping("/deduct")
    public void deductPoints(@RequestParam Long customerId, @RequestParam Long points) {
        customerServiceImpl.deductPoints(customerId, BigDecimal.valueOf(points));
    }

    @GetMapping("/balance")
    public BigDecimal getPoints(@RequestParam Long customerId) {
        return customerServiceImpl.getPoints(customerId);
    }
}

