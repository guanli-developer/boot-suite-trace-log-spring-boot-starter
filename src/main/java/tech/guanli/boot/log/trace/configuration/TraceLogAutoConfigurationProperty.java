package tech.guanli.boot.log.trace.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "tech.guanli.boot.log.trace")
public class TraceLogAutoConfigurationProperty {

	private List<String> pathPatterns = new ArrayList<>();

	private List<String> excludePathPatterns = new ArrayList<>();

	private String traceIdHeaderName = "trace-id";

	private String traceIdKey = "TRACE-ID";

	private String traceChainHeaderName = "trace-chain";

	private String traceChainKey = "TRACE-CHAIN";

}
