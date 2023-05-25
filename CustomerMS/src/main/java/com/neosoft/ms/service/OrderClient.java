package com.neosoft.ms.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "Order-service")
public interface OrderClient {
	
	@GetMapping("/")
	Object getOrdersForCustomer(@RequestParam Integer custId);

}
