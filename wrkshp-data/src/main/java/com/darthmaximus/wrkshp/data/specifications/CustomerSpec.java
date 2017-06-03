package com.darthmaximus.wrkshp.data.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.darthmaximus.wrkshp.data.domain.Customers;

public class CustomerSpec extends AbstractSpec implements Specification<Customers> {
	public CustomerSpec(SearchCriteria criteria) {
		super(criteria);
	}

	@Override
	public Predicate toPredicate(Root<Customers> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		return buildPredicate(root, query, cb);
	}
}
