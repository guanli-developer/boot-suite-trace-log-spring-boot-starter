package tech.guanli.boot.log.trace.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import tech.guanli.boot.log.trace.component.MdcInterceptor;

@Configuration
public class TraceLogWebMvcConfiger implements WebMvcConfigurer {

	@Autowired
	private MdcInterceptor mdcInterceptor;

	@Autowired
	private TraceLogAutoConfigurationProperty property;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(mdcInterceptor).order(Integer.MIN_VALUE).addPathPatterns(property.getPathPatterns())
				.excludePathPatterns(property.getExcludePathPatterns());
	}

}
