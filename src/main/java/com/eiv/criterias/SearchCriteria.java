package com.eiv.criterias;

import java.util.Map;

public class SearchCriteria extends ABaseCriteria {
	
	private Map<String, String> search;

	public Map<String, String> getSearch() {
		return search;
	}

	public void setSearch(Map<String, String> search) {
		this.search = search;
	}
}
