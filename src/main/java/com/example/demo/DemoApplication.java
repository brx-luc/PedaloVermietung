package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.UUID;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}








}

@Component
class DemoCommandLineRunner implements CommandLineRunner{
	@Autowired
	private PedaloRepository pedaloRepository;

	@Override
	public void run(String... args) throws Exception{
		PedaloImpl pedalo1_0 = new PedaloImpl();
		Pedalo pedalo1_1 = new Sonnenschirm(pedalo1_0);
		pedalo1_0.setId(1L);
		pedalo1_0.setPlaetze(4);
		pedalo1_0.setPreis(pedalo1_1.price() + 13);
		pedalo1_0.setBeschreibung(pedalo1_1.decorate());


		pedaloRepository.save(pedalo1_0);

		PedaloImpl pedalo2_0 = new PedaloImpl();
		Pedalo pedalo2_1 = new Rutschbahn(pedalo2_0);
		pedalo2_0.setId(2L);
		pedalo2_0.setPlaetze(2);
		pedalo2_0.setPreis(pedalo2_1.price() + 10);
		pedalo2_0.setBeschreibung(pedalo2_1.decorate());

		pedaloRepository.save(pedalo2_0);



	}
}


