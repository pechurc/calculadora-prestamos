package com.eiv.criterias;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ValidationException;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.ComparableExpressionBase;

public final class SortingCriteria extends ABaseCriteria {

	private static final Pattern pattern = Pattern
			.compile("^(?<field>[a-z]+)\\((?<order>asc|desc)\\)", Pattern.CASE_INSENSITIVE);
	private List<String> sort_by = new ArrayList<>();

	public List<OrderSpecifier<?>> getOrderSpecifiers(Object o) {

		Map<String, String> sortOptions = new HashMap<>();
		
		// Procesamos los parametros de orden
		for (String sortBy : sort_by) {
			Matcher matcher = pattern.matcher(sortBy);

			if (matcher.find()) {
				sortOptions.put(matcher.group("field"), matcher.group("order"));
	        }
		}
		
		List<OrderSpecifier<?>> orderSpecifier = new ArrayList<>();

		for (String fieldName : sortOptions.keySet()) {

			ComparableExpressionBase<?> field = getStringPath(fieldName, o);

			if (sortOptions.get(fieldName).toLowerCase().equals("asc")) {
				orderSpecifier.add(field.asc());
			} else if (sortOptions.get(fieldName).toLowerCase().equals("desc")) {
				orderSpecifier.add(field.desc());
			} else {
				throw new ValidationException();
			}
		}

		return orderSpecifier;
	}

	public List<String> getSort_by() {
		return sort_by;
	}

	public void setSort_by(List<String> sort_by) {
		this.sort_by = sort_by;
	}
}
