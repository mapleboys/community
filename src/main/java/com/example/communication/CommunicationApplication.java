package com.example.communication;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan("com.example.communication.mapper")
//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class CommunicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunicationApplication.class, args);
	}

}
