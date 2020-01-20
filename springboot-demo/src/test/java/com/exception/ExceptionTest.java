package com.exception;

public class ExceptionTest {
	public static void main(String[] args) {
		String name = null;
		int i = 0;
		try {
			if (name == null) {
				//throw new TianException(ErrorCodeEnum .ILLEGAL_ARGS);
			}
			if (i == 0) {
				throw new TianException(ErrorCodeEnum .ILLEGAL_ARGS, "参数不能为0");
			}
		} catch (TianException e) {
			System.out.println("异常码:" + e.getErrorCode().getCode());
			System.out.println("异常描述:"+e.getMessage());
		}
	}
}
