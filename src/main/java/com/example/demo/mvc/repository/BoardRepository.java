package com.example.demo.mvc.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.framework.data.domain.PageRequestParameter;
import com.example.demo.mvc.domain.Board;
import com.example.demo.mvc.parameter.BoardParameter;
import com.example.demo.mvc.parameter.BoardSearchParameter;

@Repository
public interface BoardRepository {

	List<Board> getList(PageRequestParameter<BoardSearchParameter> pageRequestParameter);

	Board get(int boardSeq);

	void save(BoardParameter board);

	void update(BoardParameter board);

	void delete(int boardSeq);

	void saveList(Map<String, Object> paramMap);

}
