package com.accounts.accounting.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounts.accounting.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
