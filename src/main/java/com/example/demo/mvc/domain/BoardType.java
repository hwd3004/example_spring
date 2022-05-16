package com.example.demo.mvc.domain;

public enum BoardType implements BaseCodeLabelEnum {

	NOTICE("공지사항"), FAQ("자주묻는질문"), INQUIRY("1:1문의");

	private String code;
	private String label;

	BoardType(String label) {
//		name()은 enum에서 기본 제공하는 메소드
//		리턴값은 NOTICE, FAQ, INQUIRY
		this.code = name();
		this.label = label;
	}

	@Override
	public String code() {
		return code;
	}

	@Override
	public String label() {
		return label;
	}

}
