package com.payment.controller;

import com.payment.service.CartConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final CartConsumer consumer;

    @GetMapping("/data")
    public String getPaymentData() {
        return "From PAYMENT-SERVICE: " + consumer.getCartInfo();
    }
}
