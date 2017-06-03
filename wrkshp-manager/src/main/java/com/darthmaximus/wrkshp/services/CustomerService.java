package com.darthmaximus.wrkshp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.darthmaximus.wrkshp.models.CustomerModel;
import com.darthmaximus.wrkshp.models.CustomerSearch;

public interface CustomerService {
	public Page<CustomerModel> search(Pageable pageable, CustomerSearch search);
	public CustomerModel save(CustomerModel customer);
	public CustomerModel retrieve(Long id);
	public boolean delete(Long id);
}
