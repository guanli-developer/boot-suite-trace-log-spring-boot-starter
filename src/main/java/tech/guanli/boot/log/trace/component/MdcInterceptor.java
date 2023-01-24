package tech.guanli.boot.log.trace.component;

import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tech.guanli.boot.log.trace.configuration.TraceLogAutoConfigurationProperty;

@Component
public class MdcInterceptor implements HandlerInterceptor {
	@Value("${spring.application.name:unnamed}")
	private String applicationName;

	@Autowired
	private TraceLogAutoConfigurationProperty property;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		MDC.clear();
		String traceId = request.getHeader(property.getTraceIdHeaderName());
		String traceChain = request.getHeader(property.getTraceChainHeaderName());
		if (ObjectUtils.isEmpty(traceChain)) {
			traceId = UUID.randomUUID().toString().replace("-", "");
		}
		MDC.put(property.getTraceIdKey(), traceId);
		response.setHeader(property.getTraceIdHeaderName(), traceId);
		MDC.put(property.getTraceChainKey(),
				ObjectUtils.isEmpty(traceChain) ? applicationName : traceChain + "=>" + applicationName);
		response.setHeader(property.getTraceChainHeaderName(), MDC.get(property.getTraceChainKey()));
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		MDC.clear();
	}

}
