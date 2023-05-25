package com.neosoft.ms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.ms.model.Customer;

//@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
