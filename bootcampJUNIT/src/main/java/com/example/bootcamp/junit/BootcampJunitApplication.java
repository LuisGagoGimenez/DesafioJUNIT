package com.example.bootcamp.junit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.bootcamp.junit.bbdd.BaseDatosServiceI;
import com.example.bootcamp.junit.model.Articulo;

@SpringBootApplication
public class BootcampJunitApplication implements CommandLineRunner{
	
	@Autowired
	BaseDatosServiceI baseDatosService;

	public static void main(String[] args) {
		SpringApplication.run(BootcampJunitApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		baseDatosService.initBD();
		
		baseDatosService.insertarArticulo(new Articulo("Chaqueta", 59.99));
		
		baseDatosService.findArticuloById(baseDatosService.lastIndex());
	}

}
