package com.neosoft.ms.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue
	@Column
	private Integer custId;
	@Column
	private String custName;
	@Column
	private String custEmail;
	@Column
	private String custAdd;
	
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custEmail=" + custEmail + ", custAdd="
				+ custAdd + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(custAdd, custEmail, custId, custName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(custAdd, other.custAdd) && Objects.equals(custEmail, other.custEmail)
				&& Objects.equals(custId, other.custId) && Objects.equals(custName, other.custName);
	}


	public Customer(Integer custId, String custName, String custEmail, String custAdd) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custAdd = custAdd;
	}

	public Customer() {
		super();
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustAdd() {
		return custAdd;
	}

	public void setCustAdd(String custAdd) {
		this.custAdd = custAdd;
	}

}
