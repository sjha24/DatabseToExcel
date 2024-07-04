package com.vipworld.DatabaseToExcelMailer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DatabaseToExcelMailerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseToExcelMailerApplication.class, args);
	}

}
