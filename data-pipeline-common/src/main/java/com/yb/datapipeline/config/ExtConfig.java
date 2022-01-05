package com.yb.datapipeline.config;


import com.yb.datapipeline.component.AutoConfiguredExtRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;

@Configuration
@DependsOn("extContainer")
@Import(AutoConfiguredExtRegistrar.class)
public class ExtConfig {
}