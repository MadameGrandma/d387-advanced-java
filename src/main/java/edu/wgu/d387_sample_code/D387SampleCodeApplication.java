package edu.wgu.d387_sample_code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import edu.wgu.d387_sample_code.DisplayMessage;


@SpringBootApplication
public class D387SampleCodeApplication {
	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);

		//English message thread
		DisplayMessage threadOne = new DisplayMessage("translation_en_US");
		Thread enThread = new Thread(threadOne);
		enThread.start();

		//French message thread
		DisplayMessage threadTwo = new DisplayMessage("translation_fr_CA");
		Thread frThread = new Thread(threadTwo);
		frThread.start();


	}
}
