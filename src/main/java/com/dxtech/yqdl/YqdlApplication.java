package com.dxtech.yqdl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
@ComponentScan(basePackages = {"com.dxtech.yqdl.*"})
public class YqdlApplication {

	public static void main(String[] args) {
		SpringApplication.run(YqdlApplication.class, args);
	}

}
