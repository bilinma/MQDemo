package com.bilin.kafka.spring.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:kafka.properties")
@ComponentScan(basePackages={"com.ucloudlink.kafka.spring.annotation"})
public class SpringConfig {

}
