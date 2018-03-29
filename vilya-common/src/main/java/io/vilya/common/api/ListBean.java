package io.vilya.common.api;

import java.util.List;

/**
 * @author iamaprin
 * @since 2017年10月29日 下午3:45:00
 */
public class ListBean<T> {

	private List<T> list;
	
	private Integer total;

	public List<T> getList() {
		return list;
	}

	public Integer getTotal() {
		return total;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	
}
