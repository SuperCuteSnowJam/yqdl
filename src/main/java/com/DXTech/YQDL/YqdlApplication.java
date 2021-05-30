package com.DXTech.YQDL;

import com.DXTech.YQDL.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class YqdlApplication {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(YqdlApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/mybatis")
	public String getUser(){
		 return userService.queryUser(1).toString();
	}

}
