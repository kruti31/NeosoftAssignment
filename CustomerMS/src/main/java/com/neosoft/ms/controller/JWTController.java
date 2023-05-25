package com.neosoft.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.ms.helper.JWTUtil;
import com.neosoft.ms.model.AuthenticationRequest;
import com.neosoft.ms.model.AuthenticationResponse;
import com.neosoft.ms.service.CustomerService;

@RestController
public class JWTController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping(value  ="/token", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody AuthenticationRequest request) throws Exception{
		System.out.println("Request: " +request);
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			
		}catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}catch(BadCredentialsException ex) {
			ex.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		
		 UserDetails userDetails =   this.customerService.loadUserByUsername(request.getUsername());
		 
		 String token = this.jwtUtil.generateToken(userDetails);
		 System.out.println("JWT" +token);
		 
		return ResponseEntity.ok(new AuthenticationResponse(token));
		
	}
}
