package com.neosoft.ms.model;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String jwtToken;
	
	public String getJwtToken() {
		return jwtToken;
	}

	public AuthenticationResponse(String jwtToken) {
		this.jwtToken = jwtToken;
	}

}
