package com.amigoscode.customer.resource;

import com.amigoscode.customer.dto.CustomerRequest;
import com.amigoscode.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("v1/customers")
public record CustomerResource(CustomerService customerService) {

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRequest customerRequest) {
        log.info("new customer registration {}", customerRequest);
        this.customerService.registerCustomer(customerRequest);
    }
}
