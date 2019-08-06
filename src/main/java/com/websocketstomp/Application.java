package com.websocketstomp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.websocketstomp.components.EventGenerator;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private ApplicationContext appContext;
	
	@PostConstruct
    private void init() {
		System.out.println("starting Event Generator");
		appContext.getBean(EventGenerator.class).start();
		System.out.println("started");
	}
	
}
