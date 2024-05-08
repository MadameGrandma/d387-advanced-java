package edu.wgu.d387_sample_code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class D387SampleCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);


		//English message thread
		MessageDisplay threadOne = new MessageDisplay("welcome_en.properties");
		Thread enThread = new Thread(threadOne);
		enThread.start();

		//French message thread
		MessageDisplay threadTwo = new MessageDisplay("welcome_fr.properties");
		Thread frThread = new Thread(threadTwo);
		frThread.start();
	}

}
