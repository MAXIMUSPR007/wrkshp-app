package com.darthmaximus.wrkshp.data.specifications;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import com.darthmaximus.wrkshp.data.domain.Customers;

public class CustomerSpecBuilder extends AbstractSpecBuilder<Customers> {

	private List<Specification<Customers>> specs = new LinkedList<>();
	private Specification<Customers> whereSpecs;
	
	protected Specification<Customers> getWhereSpecs() {
		return whereSpecs;
	}
	
	@Override
	public CustomerSpecBuilder buildParams(List<SearchCriteria> params) {
		for (SearchCriteria param : params) {
			specs.add(new CustomerSpec(param));
		}
		return this;
	}

	@Override
	public CustomerSpecBuilder buildWhere() {
		if (!specs.isEmpty()) {
			whereSpecs = specs.get(0);
			for (int i = 1; i < specs.size(); i++) {
				whereSpecs = Specifications.where(whereSpecs).and(specs.get(i));
			}
		}
		return this;
	}
}
