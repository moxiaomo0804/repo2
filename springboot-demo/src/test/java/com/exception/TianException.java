package com.exception;

import org.apache.commons.lang3.StringUtils;

public class TianException extends RuntimeException {

	private static final long serialVersionUID = -472262695838645864L;
	/**
	 * 错误码
	 */
	private ErrorCodeEnum  errorCode;

	public TianException(ErrorCodeEnum  errorCode) {
		super(errorCode.getDesc());
		this.setErrorCode(errorCode);
	}
	public TianException(ErrorCodeEnum  errorCode,String message) {
		super(StringUtils.isNotBlank(message) ? message : errorCode.getDesc());
		this.setErrorCode(errorCode);
	}

	public ErrorCodeEnum  getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCodeEnum  errorCode) {
		this.errorCode = errorCode;
	}
}
