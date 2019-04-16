package com.example.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Sport;

public interface SportRepository extends CrudRepository<Sport, Long> {
	List<Sport> findByid(Long id);
}
