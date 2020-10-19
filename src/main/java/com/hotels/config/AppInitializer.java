package com.hotels.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		Class[] cls = {AppContext.class };
		return cls;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class[] arrClass = { WebConfig.class };
		return arrClass;
	}

	@Override
	protected String[] getServletMappings() {
		String[] arrStr = { "/" };
		return arrStr;
	}
}
