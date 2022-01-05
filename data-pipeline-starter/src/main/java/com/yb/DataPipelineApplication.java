package com.yb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.yb.datapipeline"})
@EnableAspectJAutoProxy
@EnableScheduling
public class DataPipelineApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataPipelineApplication.class, args);
    }

}
