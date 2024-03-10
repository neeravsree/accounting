package com.accounts.accounting.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AddressRequest {
	
	private String addressline1;
	private String addressLine2;
	private String city;
	private Long pincode;

}
