package com.accounts.accounting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.accounting.entity.Designation;

import com.accounts.accounting.model.DesignationRequest;
import com.accounts.accounting.service.DesignationService;

@RestController

public class DesignationController {
	
	@Autowired
	DesignationService designationService;
	
	@PostMapping("/designation")
	public ResponseEntity<String> createDesignation(@RequestBody DesignationRequest designationRequest) throws Exception{
		designationService.createDesignation(designationRequest);
		return new ResponseEntity<String>("Designation added successfully", HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/designation/{id}")
	public ResponseEntity<?> deleteDesignation(@PathVariable Integer id) throws Exception{
		ResponseEntity<?> responseEntity=designationService.deleteDesignation(id);
		return responseEntity;

		
	}
	
	@GetMapping("/designation/{id}")
	public ResponseEntity<Designation> getDesignationById(@PathVariable Integer id) throws Exception{
		Optional<Designation> designation=designationService.getDesignationById(id);
		if(designation.isPresent())
		return new ResponseEntity<Designation>(designation.get(),HttpStatus.OK);
		else
			return ResponseEntity.notFound().build();
		
	}
	
	@GetMapping("/designation")
	public ResponseEntity<List<Designation>> gatAllDesignations() throws Exception{
		return new ResponseEntity<List<Designation>>(designationService.getAllDesignations(),HttpStatus.OK);
		
		
	}
	
	
	

}
