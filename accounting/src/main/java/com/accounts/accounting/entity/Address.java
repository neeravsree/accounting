package com.accounts.accounting.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Address {
	
	public Address(String addressline1, String addressLine2, String city, Long pincode,Employee emp) {
		this.addressline1=addressline1;
		this.addressLine2=addressLine2;
		this.city=city;
		this.pincode=pincode;
		this.employee=emp;
	}
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;
	private String addressline1;
	private String addressLine2;
	private String city;
	private Long pincode;
	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employee employee;

}
