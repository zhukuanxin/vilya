package io.vilya.common.api;

import java.util.List;

/**
 * @author erkea
 * @since 2017年10月29日 下午3:42:09
 */
public class RestListResponse<T> extends RestResponse {

	public RestListResponse(List<T> list) {
		setData(createListBean(list));
	}
	
	private ListBean<T> createListBean(List<T> list) {
		ListBean<T> bean = new ListBean<>();
		bean.setList(list);
		bean.setTotal(list == null ? 0 : list.size());
		return bean;
	}
	
}
