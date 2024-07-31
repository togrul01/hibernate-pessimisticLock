package org.example.hibernatepessimist;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.example.hibernatepessimist.entity.Customer;
import org.example.hibernatepessimist.repo.CustomerRepository;
import org.example.hibernatepessimist.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
@RequiredArgsConstructor
public class HibernatePessimistApplication implements CommandLineRunner {
    private final CustomerRepository customerRepository;

    private final CustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(HibernatePessimistApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Faker faker = new Faker();
//        for (int i = 0; i < 100; i++) {
//            Customer customer = new Customer();
//            customer.setName(faker.name().name());
//            customer.setSurName(faker.name().lastName());
//            customer.setAge(faker.number().numberBetween(0, 75));
//            customer.setPhone(faker.phoneNumber().cellPhone());
//            customer.setEmail(faker.bothify("????##@gmail.com"));
//            customer.setGender(faker.options().option("female", "male"));
//            double randomDouble = faker.number().randomDouble(2, 0, 10000);
//            customer.setBalance(BigDecimal.valueOf(randomDouble));
//            customerRepository.save(customer);
//        }
        customerService.batchInsert();
    }
}
