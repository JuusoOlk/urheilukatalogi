package com.example.urheilukatalogi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.urheilukatalogi.domain.CategoryRepository;
import com.example.urheilukatalogi.domain.SportRepository;
import com.example.urheilukatalogi.domain.UserRepository;
import com.example.urheilukatalogi.model.Sport;
import com.example.urheilukatalogi.model.SportCategory;
import com.example.urheilukatalogi.model.User;

@SpringBootApplication
public class UrheilukatalogiApplication {
	@Autowired
	private UserRepository urepository;
	@Autowired
	private SportRepository srepository;
	
	public static void main(String[] args) {
		SpringApplication.run(UrheilukatalogiApplication.class, args);
	}

	@Bean
	public CommandLineRunner Sport(SportRepository srepository, CategoryRepository crepository, UserRepository urepository) {
	return (args) -> {
		
		crepository.save(new SportCategory("Football"));
		crepository.save(new SportCategory("Ice-Hockey"));
		crepository.save(new SportCategory("Baseball"));
	
		srepository.save(new Sport("Kärpät", "Finland", "1", "3", crepository.findByName("Football").get(0)));
		
		User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
		User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
		urepository.save(user1);
		urepository.save(user2);
		
	};
	
	}
	
}

