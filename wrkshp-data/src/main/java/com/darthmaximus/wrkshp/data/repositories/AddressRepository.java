package com.darthmaximus.wrkshp.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.darthmaximus.wrkshp.data.domain.Addresses;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Addresses, Long> {
	public Page<Addresses> findByCustomerId(Pageable pageable, Long customerId);
}
