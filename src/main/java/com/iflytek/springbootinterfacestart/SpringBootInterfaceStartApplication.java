package com.iflytek.springbootinterfacestart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.didispace.swagger.EnableSwagger2Doc;

@EnableSwagger2Doc
@SpringBootApplication
public class SpringBootInterfaceStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootInterfaceStartApplication.class, args);
	}
}
