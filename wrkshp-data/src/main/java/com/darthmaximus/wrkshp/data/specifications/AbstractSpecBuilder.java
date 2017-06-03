package com.darthmaximus.wrkshp.data.specifications;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

public abstract class AbstractSpecBuilder<T> {
	private List<SearchCriteria> params = new LinkedList<>();
	
	public AbstractSpecBuilder<T> with(String key, SpecOp op, Object value) {
		params.add(new SearchCriteria(key, op, value));
		return this;
	}
	
	public AbstractSpecBuilder<T> with(String key, SpecOp op, List<Object> values) {
		params.add(new SearchCriteria(key, op, values));
		return this;
	}
	
	public AbstractSpecBuilder<T> with(String key, SpecOp op, Object rangeStart, Object rangeEnd) {
		params.add(new SearchCriteria(key, op, rangeStart, rangeEnd));
		return this;
	}
	
	public AbstractSpecBuilder<T> with(String key, SpecOp op, LocalDateTime dateStart, LocalDateTime dateEnd) {
		params.add(new SearchCriteria(key, op, dateStart, dateEnd));
		return this;
	}

	public Specification<T> build() {
		if (params.size() == 0) {
			return null;
		}

		buildParams(params);
		buildWhere();
		
		return getWhereSpecs();
	}
	
	public abstract AbstractSpecBuilder<T> buildParams(List<SearchCriteria> params);
	public abstract AbstractSpecBuilder<T> buildWhere();
	protected abstract Specification<T> getWhereSpecs();
}
