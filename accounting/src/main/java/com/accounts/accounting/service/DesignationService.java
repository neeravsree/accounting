package com.accounts.accounting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.accounts.accounting.entity.Designation;
import com.accounts.accounting.model.DesignationRequest;
import com.accounts.accounting.repo.DesignationRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DesignationService {
	@Autowired
	DesignationRepository designationRepo;
	
	public void createDesignation(DesignationRequest designationRequest) throws Exception{
		Designation designation=Designation.builder().name(designationRequest.getName()).build();
		designationRepo.save(designation);
	}

	public ResponseEntity<?> deleteDesignation(Integer id) throws Exception{
		 Optional<Designation> existingDesignation = designationRepo.findById(id);
	        if(existingDesignation.isPresent()){
	        	designationRepo.deleteById(id);
	            return ResponseEntity.ok().build();
	        }
	        return ResponseEntity.notFound().build();
		
	
		
	}

	public Optional<Designation> getDesignationById(Integer id) {
		Optional<Designation> designation=designationRepo.findById(id);
		return designation;
	}

	public List<Designation> getAllDesignations() {
		return designationRepo.findAll();
		
	}

	

}
