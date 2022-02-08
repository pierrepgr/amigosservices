package com.amigoscode.customer.repository;

import com.amigoscode.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Customers extends JpaRepository<Customer, Integer> {
}
