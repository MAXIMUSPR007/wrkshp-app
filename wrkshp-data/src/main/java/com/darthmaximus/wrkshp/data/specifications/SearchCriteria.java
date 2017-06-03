package com.darthmaximus.wrkshp.data.specifications;

import java.time.LocalDateTime;
import java.util.List;

public class SearchCriteria {
	private String key;
	private SpecOp op;
	private Object value;
	private List<Object> values;
	private Object rangeStart;
	private Object rangeEnd;
	private LocalDateTime dateStart;
	private LocalDateTime dateEnd;
	
	public SearchCriteria(String key, SpecOp op, Object value) {
		this.key = key;
		this.op = op;
		this.value = value;
	}
	
	public SearchCriteria(String key, SpecOp op, List<Object> values) {
		this.key = key;
		this.op = op;
		this.values = values;
	}

	public SearchCriteria(String key, SpecOp op, Object rangeStart, Object rangeEnd) {
		this.key = key;
		this.op = op;
		this.rangeStart = rangeStart;
		this.rangeEnd = rangeEnd;
	}
	
	public SearchCriteria(String key, SpecOp op, LocalDateTime dateStart, LocalDateTime dateEnd) {
		this.key = key;
		this.op = op;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public SpecOp getOp() {
		return op;
	}
	public void setOp(SpecOp op) {
		this.op = op;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public List<Object> getValues() {
		return values;
	}
	public void setValues(List<Object> values) {
		this.values = values;
	}
	public Object getRangeStart() {
		return rangeStart;
	}
	public void setRangeStart(Object rangeStart) {
		this.rangeStart = rangeStart;
	}
	public Object getRangeEnd() {
		return rangeEnd;
	}
	public void setRangeEnd(Object rangeEnd) {
		this.rangeEnd = rangeEnd;
	}
	public LocalDateTime getDateStart() {
		return dateStart;
	}
	public void setDateStart(LocalDateTime dateStart) {
		this.dateStart = dateStart;
	}
	public LocalDateTime getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(LocalDateTime dateEnd) {
		this.dateEnd = dateEnd;
	}
}