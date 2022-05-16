package com.example.demo.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configuration.exception.BaseException;
import com.example.demo.configuration.http.BaseResponse;
import com.example.demo.configuration.http.BaseResponseCode;
import com.example.demo.mvc.domain.Board;
import com.example.demo.mvc.parameter.BoardParameter;
import com.example.demo.mvc.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/board")
@Api(tags = "게시판 API")
public class BoardController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private BoardService boardService;

	@GetMapping
	@ApiOperation(value = "목록 조회", notes = "게시물 목록 정보를 조회할 수 있습니다.")
	public BaseResponse<List<Board>> getList() {
		return new BaseResponse<List<Board>>(boardService.getList());
	}

	@GetMapping("/{boardSeq}")
	@ApiOperation(value = "상세 조회", notes = "게시물 번호에 해당하는 상세 정보를 조회할 수 있습니다.")
	@ApiImplicitParams({ @ApiImplicitParam(name = "boardSeq", value = "게시물 번호", example = "1") })
	public BaseResponse<Board> get(@PathVariable int boardSeq) {
		Board board = boardService.get(boardSeq);

		if (board == null) {
			throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[] { "게시물" });
		}

		return new BaseResponse<Board>(board);
	}

//	등록, 수정
	@SuppressWarnings("deprecation")
	@PutMapping("/save")
	@ApiOperation(value = "등록 / 수정 처리", notes = "신규 게시물 저장 및 기존 게시물 업데이트가 가능합니다.")
	@ApiImplicitParams({ @ApiImplicitParam(name = "boardSeq", value = "게시물 번호", example = "1"),
			@ApiImplicitParam(name = "title", value = "제목", example = "스프링"),
			@ApiImplicitParam(name = "contents", value = "내용", example = "스프링 강좌") })
	public BaseResponse<Integer> save(BoardParameter parameter) {
//		제목 필수 체크
		if (StringUtils.isEmpty(parameter.getTitle())) {
			throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] { "title", "제목" });
		}

//		내용 필수 체크
		if (StringUtils.isEmpty(parameter.getContents())) {
			throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] { "contents", "내용" });
		}

		boardService.save(parameter);
		return new BaseResponse<Integer>(parameter.getBoardSeq());
	}

	@DeleteMapping("/{boardSeq}")
	@ApiOperation(value = "삭제 처리", notes = "신규 게시물 저장 및 기존 게시물 업데이트가 가능합니다.")
	@ApiImplicitParams({ @ApiImplicitParam(name = "boardSeq", value = "게시물 번호", example = "1") })
	public BaseResponse<Boolean> delete(@PathVariable int boardSeq) {
		Board board = boardService.get(boardSeq);

		if (board == null) {
			return new BaseResponse<Boolean>(false);
		}

		boardService.delete(boardSeq);
		return new BaseResponse<Boolean>(true);
	}

//	 대용량 등록 처리
	@ApiOperation(value = "대용량 등록 처리1", notes = "대용량 등록 처리1")
	@PutMapping("/saveList1")
	public BaseResponse<Boolean> saveList1() {
		int count = 0;

		List<BoardParameter> list = new ArrayList<>();

//		테스트를 위한 10000건의 데이터 생성
		while (true) {
			count++;
			String title = RandomStringUtils.randomAlphabetic(10);
			String contents = RandomStringUtils.randomAlphabetic(10);

			list.add(new BoardParameter(title, contents));

			if (count >= 10000) {
				break;
			}
		}

		long start = System.currentTimeMillis();
		boardService.saveList1(list);
		long end = System.currentTimeMillis();
		logger.info("실행시간 : {}", (end - start) / 1000.0);

		return new BaseResponse<Boolean>(true);
	}

//	 대용량 등록 처리
	@ApiOperation(value = "대용량 등록 처리2", notes = "대용량 등록 처리2")
	@PutMapping("/saveList2")
	public BaseResponse<Boolean> saveList2() {
		int count = 0;

		List<BoardParameter> list = new ArrayList<>();

//		테스트를 위한 10000건의 데이터 생성
		while (true) {
			count++;
			String title = RandomStringUtils.randomAlphabetic(10);
			String contents = RandomStringUtils.randomAlphabetic(10);

			list.add(new BoardParameter(title, contents));

			if (count >= 10000) {
				break;
			}
		}

		long start = System.currentTimeMillis();
		boardService.saveList2(list);
		long end = System.currentTimeMillis();
		logger.info("실행시간 : {}", (end - start) / 1000.0);

		return new BaseResponse<Boolean>(true);
	}

}
