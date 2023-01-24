package tech.guanli.boot.log.trace.component;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tech.guanli.boot.log.trace.configuration.TraceLogAutoConfigurationProperty;

@Component
public final class TraceReader {

	@Autowired
	private TraceLogAutoConfigurationProperty property;

	public final String getTraceId() {
		return MDC.get(property.getTraceIdKey());
	}

	public final String getTraceChain() {
		return MDC.get(property.getTraceChainKey());
	}

}
