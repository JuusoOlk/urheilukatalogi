package com.example.domain;

import org.springframework.data.repository.CrudRepository;

import com.example.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
