package com.payment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartConsumer {

    private final DiscoveryClient client;

    public String getCartInfo() {
        List<ServiceInstance> serviceInstanceList = client.getInstances("CART-SERVICE");
        ServiceInstance cartService = serviceInstanceList.get(0);

        String url = cartService.getUri() + "/cart/data";

        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject(url, String.class);

        return response;
    }
}
