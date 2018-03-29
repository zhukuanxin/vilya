package io.vilya.common.api;

/**
 * @author iamaprin
 * @since 2017年10月29日 下午2:08:27
 */
public class RestResponse {
	
	private Integer code;
	
	private String message;
	
	private long systemTime;
	
	private Object data;

	public RestResponse() {
		this(null);
	}
	
	public RestResponse(Object data) {
		code = ResultCode.SUCC;
		systemTime = System.currentTimeMillis();
		this.data = data;
	}
	
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
	
}
