package com.shipment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentConsumer {

    private final DiscoveryClient client;
    private final RestTemplate restTemplate;

    public String getPaymentData() {
        List<ServiceInstance> serviceInstances = client.getInstances("PAYMENT-SERVICE");

        ServiceInstance paymentService = serviceInstances.get(0);

        String url = paymentService.getUri() + "/payment/data";

        return restTemplate.getForObject(url, String.class);
    }
}
