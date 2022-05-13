package com.example.demo.configuration.exception;

import com.example.demo.configuration.http.BaseResponseCode;

// AbstractBaseException 추상 클래스를 상속 받아서 만든 기본적인 예외 처리 클래스
public class BaseException extends AbstractBaseException {

	private static final long serialVersionUID = 8342235231880246631L;

	public BaseException() {
	}

	public BaseException(BaseResponseCode responseCode) {
		this.responseCode = responseCode;
	}

	public BaseException(BaseResponseCode responseCode, String[] args) {
		this.responseCode = responseCode;
		this.args = args;
	}

}