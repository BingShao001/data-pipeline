package com.yb.datapipeline.config;


import com.yb.datapipeline.component.ExtAutoConfiguredRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;

@Configuration
@DependsOn("extContainer")
@Import(ExtAutoConfiguredRegistrar.class)
public class ExtConfig {
}