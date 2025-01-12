package com.githubactions.devops_cicd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DevopsCicdApplication {

	@GetMapping("/cicd")
	public String githubAction(){
		return "GitHUb Action is working for CI/CD pipeline... ";
	}

	public static void main(String[] args) {
		SpringApplication.run(DevopsCicdApplication.class, args);
	}

}
