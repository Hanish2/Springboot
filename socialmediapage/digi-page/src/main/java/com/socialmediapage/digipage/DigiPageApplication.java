package com.socialmediapage.digipage;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.socialmediapage.digipage.user.UserController;
@SpringBootApplication
public class DigiPageApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(DigiPageApplication.class, args);
	}

}
