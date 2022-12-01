package com.shipment.controller;

import com.shipment.service.PaymentConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shipment")
@RequiredArgsConstructor
public class ShipmentController {

    private final PaymentConsumer paymentConsumer;

    @GetMapping("/data")
    public String getShipment(){
        return "From Shipment service: " + paymentConsumer.getPaymentData();
    }
}
