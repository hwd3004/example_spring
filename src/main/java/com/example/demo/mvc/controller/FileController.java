package com.example.demo.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configuration.GlobalConfig;
import com.example.demo.configuration.http.BaseResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/file")
@Api(tags = "파일 API")
public class FileController {

	@Autowired
	private GlobalConfig config;

	Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping
	@ApiOperation(value = "업로드", notes = "")
	public BaseResponse<Boolean> save() {
		logger.debug("config : {}", config);
		String uploadFilePath = config.getUploadPath();
		logger.debug("uploadFilePath : {}", uploadFilePath);
		return new BaseResponse<Boolean>(true);
	}

}
