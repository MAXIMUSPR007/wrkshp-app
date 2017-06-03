package com.darthmaximus.wrkshp.services;

import static com.darthmaximus.wrkshp.data.specifications.SpecOp.*;

import java.util.LinkedList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.darthmaximus.wrkshp.data.domain.Customers;
import com.darthmaximus.wrkshp.data.repositories.CustomerRepository;
import com.darthmaximus.wrkshp.data.specifications.CustomerSpecBuilder;
import com.darthmaximus.wrkshp.data.specifications.SearchCriteria;
import com.darthmaximus.wrkshp.exceptions.CustomerNotFoundException;
import com.darthmaximus.wrkshp.models.CustomerModel;
import com.darthmaximus.wrkshp.models.CustomerSearch;

@Service
public class DefaultCustomerService implements CustomerService {
	@Autowired
	private ModelMapper defaultModelMapper;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Page<CustomerModel> search(Pageable pageable, CustomerSearch search) {
		Assert.notNull(search, "Search object cannot be null.");
		CustomerSpecBuilder specBuilder = new CustomerSpecBuilder();
		List<SearchCriteria> params = new LinkedList<>();
		
		if (!StringUtils.isEmpty(search.getFirstName())) {
			params.add(new SearchCriteria("firstName", LK, search.getFirstName()));
		}
		if (!StringUtils.isEmpty(search.getLastName())) {
			params.add(new SearchCriteria("lastName", LK, search.getLastName()));
		}
		if (!StringUtils.isEmpty(search.getLastName())) {
			params.add(new SearchCriteria("email", LK, search.getEmail()));
		}
		if (!StringUtils.isEmpty(search.getCellPhone())) {
			params.add(new SearchCriteria("cellPhone", EQ, search.getCellPhone()));
		}
		if (!StringUtils.isEmpty(search.getHomePhone())) {
			params.add(new SearchCriteria("homePhone", EQ, search.getHomePhone()));
		}
		
		specBuilder
			.buildParams(params)
			.buildWhere();
		
		return convert(customerRepository.findAll(specBuilder.build(), pageable));
	}

	@Override
	public CustomerModel save(CustomerModel customer) {
		Customers customerDT = defaultModelMapper.map(customer, Customers.class); 
		return defaultModelMapper.map(customerRepository.save(customerDT), CustomerModel.class);
	}

	@Override
	public CustomerModel retrieve(Long id) {
		Customers customerDT = customerRepository.findOne(id);
		if (customerDT != null) { 
			return defaultModelMapper.map(customerDT, CustomerModel.class);
		}
		throw new CustomerNotFoundException();
	}

	@Override
	public boolean delete(Long id) {
		customerRepository.delete(id);
		return true; 
	}
	
	private Page<CustomerModel> convert(Page<Customers> source) {
		return source.map(new Converter<Customers, CustomerModel>() {
			@Override
			public CustomerModel convert(Customers source) {
				return defaultModelMapper.map(source, CustomerModel.class);
			}
		});
	}
}
