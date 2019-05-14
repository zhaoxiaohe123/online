package com.zxh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.zxh.config.ResponseBodyWrapFactory;
import com.zxh.config.ResponseExceptionHandle;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.zxh.dao")
public class OnlineExaminationApplication {
	

	@Bean
	public ResponseBodyWrapFactory responseBodyWrapFactory(){
		return new ResponseBodyWrapFactory();
	}
	
	@Bean
	public ResponseExceptionHandle responseExceptionHandle(){
		return new ResponseExceptionHandle();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineExaminationApplication.class, args);
	}
}
