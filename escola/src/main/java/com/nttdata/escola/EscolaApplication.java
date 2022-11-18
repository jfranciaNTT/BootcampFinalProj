package com.nttdata.escola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("escola")
public class EscolaApplication {

	public static void main(String[] args) {
		new SpringApplication(EscolaApplication.class).run(args);
	}

}
