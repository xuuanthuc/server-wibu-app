package com.example.apiwibuapp;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import storage.AppStorage;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		AppStorage appStorage = AppStorage.getInstance();
		appStorage.loadConfig(new Gson());
		SpringApplication.run(Application.class, args);
	}

}
