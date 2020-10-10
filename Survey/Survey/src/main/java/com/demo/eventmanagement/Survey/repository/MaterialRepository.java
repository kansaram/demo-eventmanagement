package com.demo.eventmanagement.Survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.eventmanagement.Survey.entity.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long >{
	
	Material getByTopic(String topic);
}
