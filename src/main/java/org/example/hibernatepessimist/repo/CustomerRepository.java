package org.example.hibernatepessimist.repo;


import jakarta.persistence.LockModeType;
import org.example.hibernatepessimist.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Customer findByName(String name);

}
