package com.thw.constant;

public enum  BizError {
	SYSTEM_ERROR("000", "系统异常"),
	PARAMETER_ERROR("001", "参数错误"),
	NCT_PERMISSION_ERROR("002","没有权限");
	private final String errorCode;
	private final String errorDesc;

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	BizError(String errorCode, String errorDesc) {
		this.errorCode = errorCode;
		this.errorDesc = errorDesc;
	}
}
