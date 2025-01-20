package com.Bank.Adminms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AdminmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminmsApplication.class, args);
	}

}
