package io.vilya.common.api;

import java.util.List;

/**
 * @author iamaprin
 * @since 2018年3月19日 上午7:52:47
 */
public class RestResponseFactory {

	private RestResponseFactory() {}
	
	public static RestResponse create() {
		return new RestResponse();
	}
	
	public static RestResponse create(Integer code) {
		return new RestResponse().setCode(code);
	}
	
	public static RestResponse create(Integer code, Object data) {
		return new RestResponse().setCode(code).setData(data);
	}
	
	public static RestResponse create(Object data) {
		return new RestResponse(data);
	}
	
	public static <T> RestResponse create(List<T> list) {
		return new RestListResponse<>(list);
	}
	
}
