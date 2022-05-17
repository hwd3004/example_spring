package com.example.demo.configuration;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import ch.qos.logback.classic.Logger;

public class GlobalConfig {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private ResourceLoader resourceLoader;

	private String uploadPath;

	public String getUploadPath() {
		return uploadPath;
	}

	@PostConstruct
	public void init() {
		String[] activeProfiles = context.getEnvironment().getActiveProfiles();

		String activeProfile = "local";

		if (ObjectUtils.isNotEmpty(activeProfiles)) {
			activeProfile = activeProfiles[0];
		}

		String resourcePath = String.format("classpath:globals/global-%s.properties", activeProfile);

		try {
			Resource resource = resourceLoader.getResource(resourcePath);
			Properties properties = PropertiesLoaderUtils.loadProperties(resource);
			uploadPath = properties.getProperty("uploadFile.path");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
