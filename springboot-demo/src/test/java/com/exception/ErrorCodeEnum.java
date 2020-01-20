package com.exception;

import org.apache.commons.lang3.StringUtils;

public enum ErrorCodeEnum  {
	SYS_ERROR("SYS_ERROR","系统错误，请重试"),
	UNKNOWN_ERROR("UNKNOWN_ERROR","未知的系统异常"),
	SERVICE_INVOKE_FAIL("SERVICE_INVOKE_FAIL","服务器调用失败"),
	ILLEGAL_ARGS("ILLEGAL_ARGS","参数校验错误");

	private String code;
	private String desc;

	public static ErrorCodeEnum  getDescByCode(String code) {
		for (ErrorCodeEnum  result : values()) {
			if (StringUtils.equals(result.getCode(),code)) {
				return result;
			}
		}
		return null;
	}

	ErrorCodeEnum (String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
