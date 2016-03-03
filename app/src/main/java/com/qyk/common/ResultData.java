package com.qyk.common;

import java.io.Serializable;

/**
 * 返回数据类型
 * @param <T>
 */
public class ResultData<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int STATUS_NORMAL = 1;
	public static final int STATUS_ERROR = 0;
	private Integer status = STATUS_NORMAL;
	private String message;
	private T data;

	public ResultData() {

	}

	public ResultData(Integer status, String message, T data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResultData [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
}
