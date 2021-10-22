package com.iiht.training.datingapp.filter;

import java.util.ArrayList;
import java.util.Objects;

public class Filter {

	private FilterType type;
	private ArrayList<?> values = new ArrayList<>();

	public enum FilterType {
		AGE, CITY, COUNTRY, GENDER;
	}

	public Filter() {
	}

	public Filter(FilterType type, ArrayList<?> values) {
		super();
		this.type = type;
		this.values = values;
	}

	public FilterType getType() {
		return type;
	}

	public void setType(FilterType type) {
		this.type = type;
	}

	public ArrayList<?> getValues() {
		return values;
	}

	public void setValues(ArrayList<?> values) {
		this.values = values;
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, values);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filter other = (Filter) obj;
		return type == other.type && Objects.equals(values, other.values);
	}
	
	
}
