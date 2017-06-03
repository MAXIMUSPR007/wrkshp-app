package com.darthmaximus.wrkshp.data.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public abstract class AbstractSpec {
	private SearchCriteria criteria;
	
	public AbstractSpec(SearchCriteria criteria) {
		this.criteria = criteria;
	}
	
	public SearchCriteria getCriteria() {
		return criteria;
	}
	public void setCriteria(SearchCriteria criteria) {
		this.criteria = criteria;
	}
	
	protected Predicate buildPredicate(Root<?> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		Boolean hasChild = criteria.getKey().indexOf(".") >= 0;
		String child = hasChild ? criteria.getKey().substring(0, criteria.getKey().indexOf(".")) : null;
		String key = criteria.getKey().replaceAll(child + ".", "");
		From<?, ?> from = hasChild ? root.join(child) : root;
		switch (criteria.getOp()) {
		case EQ:
			return cb.equal(from.get(key), criteria.getValue());
		case LT:
			return cb.lessThan(from.get(key), criteria.getValue().toString());
		case LE:
			return cb.lessThanOrEqualTo(from.get(key), criteria.getValue().toString());
		case GT:
			return cb.greaterThan(from.get(key), criteria.getValue().toString());
		case GE:
			return cb.greaterThanOrEqualTo(from.get(key), criteria.getValue().toString());
		case LK:
			return cb.like(from.get(key), "%" + criteria.getValue() + "%");
		case RG:
			if (criteria.getDateStart() != null && criteria.getDateEnd() != null) {
				return cb.between(from.get(key), criteria.getDateStart(), criteria.getDateEnd());
			}
			return cb.between(from.get(key), criteria.getRangeStart().toString(), criteria.getRangeEnd().toString());
		case IN:
			return from.get(key).in(criteria.getValues());
		default:
			return cb.equal(from.get(key), criteria.getValue());
		}
	}
}