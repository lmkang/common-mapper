package org.wandaima.web.configure;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wandaima.core.BaseMapperInterceptor;

@Configuration
public class MyConfiguration {

	@Bean
	public BaseMapperInterceptor baseMapperInterceptor() {
		BaseMapperInterceptor baseMapperInterceptor = new BaseMapperInterceptor();
		Properties props = new Properties();
		props.setProperty("common-mapper.debug", "true");
		baseMapperInterceptor.setProperties(props);
		return baseMapperInterceptor;
	}
}
