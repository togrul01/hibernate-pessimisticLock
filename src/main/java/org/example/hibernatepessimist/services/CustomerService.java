package org.example.hibernatepessimist.services;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.example.hibernatepessimist.entity.Customer;
import org.example.hibernatepessimist.repo.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    private final EntityManager entityManager;

    @Transactional()
    public void incrementCustomer() {
        Customer c = customerRepository.findById(2L).get();
        c.setBalance(c.getBalance().add(BigDecimal.ONE));
    }

    @Transactional
    public void batchInsert() {
        Faker faker = new Faker();
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Customer customer = new Customer();
            customer.setName(faker.name().name());
            customer.setSurName(faker.name().lastName());
            customer.setAge(faker.number().numberBetween(0, 75));
            customer.setPhone(faker.phoneNumber().cellPhone());
            customer.setEmail(faker.bothify("????##@gmail.com"));
            customer.setGender(faker.options().option("female", "male"));
            double randomDouble = faker.number().randomDouble(2, 0, 10000);
            customer.setBalance(BigDecimal.valueOf(randomDouble));
            customers.add(customer);
        }
        customerRepository.saveAll(customers);
    }
}
