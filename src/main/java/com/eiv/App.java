package com.eiv;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eiv.converters.GeneroConverter;
import com.eiv.enums.GeneroEnum;

@SpringBootApplication
public class App implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        GeneroConverter generoConverter = new GeneroConverter();
        
        System.out.println(generoConverter.convertToDatabaseColumn(GeneroEnum.MASCULINO));
        System.out.println(generoConverter.convertToEntityAttribute('F'));
        System.out.println(generoConverter.convertToEntityAttribute('d'));
    }

}
