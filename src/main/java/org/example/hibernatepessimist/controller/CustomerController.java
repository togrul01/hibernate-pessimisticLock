package org.example.hibernatepessimist.controller;

import lombok.RequiredArgsConstructor;
import org.example.hibernatepessimist.services.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private  final CustomerService customerService;


    @GetMapping("/inc")
    void increment(){
        customerService.incrementCustomer();
    }
}
