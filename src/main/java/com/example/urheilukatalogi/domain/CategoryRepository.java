package com.example.urheilukatalogi.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.urheilukatalogi.model.SportCategory;

public interface CategoryRepository extends CrudRepository<SportCategory, Long> {
	
	List<SportCategory> findByName(String name);
	
}
