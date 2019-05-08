package io.vilya.common.api;

/**
 * @author erkea
 * @since 2017年10月29日 下午2:08:27
 */
public class RestResponse {
	
	private Integer code;
	
	private String message;
	
	private Object data;
	
	private long systemTime = System.currentTimeMillis();
	
	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public long getSystemTime() {
		return systemTime;
	}

	public Object getData() {
		return data;
	}

	public RestResponse setCode(Integer code) {
		this.code = code;
		return this;
	}

	public RestResponse setMessage(String message) {
		this.message = message;
		return this;
	}
	
	public RestResponse setData(Object data) {
		this.data = data;
		return this;
	}
	
	public static RestResponse success() {
		return success(null);
	}
	
	public static RestResponse success(Object data) {
		RestResponse response = new RestResponse();
		response.code = ResultCode.SUCC;
		response.systemTime = System.currentTimeMillis();
		return response;
	}
	
	public static RestResponse failure(String message) {
		RestResponse response = new RestResponse();
		response.code = ResultCode.FAIL;
		response.message = message;
		return response;
	}
	
}
