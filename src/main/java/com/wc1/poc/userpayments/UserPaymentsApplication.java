package com.wc1.poc.userpayments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.wc1.poc"})
public class UserPaymentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserPaymentsApplication.class, args);
	}

}
