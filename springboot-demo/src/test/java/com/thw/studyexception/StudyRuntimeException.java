package com.thw.studyexception;

import com.thw.constant.BizError;

public class StudyRuntimeException extends RuntimeException {
	private BizError errorCode;
	private  String errorMessage;
}
