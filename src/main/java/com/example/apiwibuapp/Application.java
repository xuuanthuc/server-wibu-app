package com.example.apiwibuapp;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import storage.AppStorage;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Application {

	public static void main(String[] args) {
		AppStorage appStorage = AppStorage.getInstance();
		appStorage.loadConfig(new Gson());
		SpringApplication.run(Application.class, args);
	}

}
