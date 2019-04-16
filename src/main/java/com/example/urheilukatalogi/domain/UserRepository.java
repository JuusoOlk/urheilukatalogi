package com.example.urheilukatalogi.domain;

import org.springframework.data.repository.CrudRepository;

import com.example.urheilukatalogi.model.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
