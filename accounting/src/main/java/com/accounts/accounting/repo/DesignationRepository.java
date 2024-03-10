package com.accounts.accounting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accounts.accounting.entity.Designation;

public interface DesignationRepository extends JpaRepository<Designation, Integer>{

	@Modifying
	@Query("delete from Designation where name=:name")
	void deleteByName(@Param("name") String name);

}
