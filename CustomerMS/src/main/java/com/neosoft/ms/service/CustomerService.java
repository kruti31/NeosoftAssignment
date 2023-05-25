package com.neosoft.ms.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neosoft.ms.model.Customer;
import com.neosoft.ms.repository.CustomerRepository;

@Service
public class CustomerService implements UserDetailsService{
	
	@Autowired
	private CustomerRepository customerRepo;
	
	public Iterable<Customer> getMyCustomer(){
		return customerRepo.findAll();
	}

	public Customer getCustomerById(Integer custId) {
		return customerRepo.findById(custId).get();

	}
	
	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);

	}
    
	public void deletebyId(Integer custId) {
		customerRepo.deleteById(custId);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if(username.equals("Krutika")) {
			return new User("Krutika", "password", new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("User not found !!");
		}
	}

}
