package com.example.demo.configuration.exception;

import com.example.demo.configuration.http.BaseResponseCode;

// 추상 클래스를 만드는 이유
// 기본적으로 자바에서 사용하는 예외 클래스를 써도 되지만
// 직접 커스텀하여 예외 처리를 추가할 경우
// 공통 에러 포맷이나 에러 코드를 미리 추상 클래스로 만들어서
// 상황에 맞게 해당 클래스를 상속받아서 예외 처리 클래스를 만들 수 있음
public abstract class AbstractBaseException extends RuntimeException {

	private static final long serialVersionUID = 8342235231880246631L;

	protected BaseResponseCode responseCode;
	protected Object[] args;

	public AbstractBaseException() {

	}

	public AbstractBaseException(BaseResponseCode responseCode) {
		this.responseCode = responseCode;
	}

	public BaseResponseCode getResponseCode() {
		return responseCode;
	}

	public Object[] getArgs() {
		return args;
	}

}
