package io.vilya.common.bean.req;

/**
 * @author erkea
 * @since 2018年3月19日 上午12:15:05
 */
public class QueryBean {

	private Integer currentPage;
	
	private Integer pageSize;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
