package com.accounts.accounting.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class DesignationRequest {
	
	private int id;
	private String name;

}
