package com.eiv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eiv.converters.GeneroConverter;
import com.eiv.enums.GeneroEnum;
import com.eiv.repositories.ProvinciaRepository;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    ProvinciaRepository provinciaRepository;
    
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        provinciaRepository.findAll().forEach(provinciaEntity -> {
            System.out.println("Provincia: " +  provinciaEntity);
        });
        
    }

}
