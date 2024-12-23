package com.dairy.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dairy.app.service.iface.MyFunctinalInterfcae;

@SpringBootApplication
public class DairyHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(DairyHubApplication.class, args);

		MyFunctinalInterfcae functinalInterfcae = () -> System.out.println("Called");
		functinalInterfcae.excuate();
		String string = functinalInterfcae.getPrintStatement();
		System.out.println("O/P :" + string);
		
		
		Runnable runnable = () -> {System.out.println("Run method called.");};
		
		Thread thread = new Thread(runnable);
		thread.start();
	}

}
