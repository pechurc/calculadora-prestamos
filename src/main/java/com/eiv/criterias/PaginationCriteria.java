package com.eiv.criterias;

import javax.validation.constraints.Min;

public final class PaginationCriteria {

	@Min(0L)
	private Long offset = 0L;
	@Min(1L)
	private Long top = 1L;
	
	public Long getOffset() {
		return offset;
	}
	public void setOffset(Long offset) {
		this.offset = offset;
	}
	public Long getTop() {
		return top;
	}
	public void setTop(Long top) {
		this.top = top;
	}	
}
