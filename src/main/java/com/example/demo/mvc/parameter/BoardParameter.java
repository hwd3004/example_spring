package com.example.demo.mvc.parameter;

import com.example.demo.mvc.domain.BoardType;

import lombok.Data;

@Data
public class BoardParameter {

	private int boardSeq;
	private String title;
	private String contents;
	private BoardType boardType;

	public BoardParameter() {

	}

	public BoardParameter(String title, String contents) {
		this.title = title;
		this.contents = contents;
	}
}
