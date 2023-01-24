package tech.guanli.boot.log.trace.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import tech.guanli.boot.log.trace.Package;

@AutoConfiguration
@ComponentScan(basePackageClasses = { Package.class })
@EnableConfigurationProperties(TraceLogAutoConfigurationProperty.class)
public class TraceLogAutoConfiguration {

}
