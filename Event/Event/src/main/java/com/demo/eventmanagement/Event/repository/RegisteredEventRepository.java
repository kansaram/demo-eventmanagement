package com.demo.eventmanagement.Event.repository;

import org.springframework.stereotype.Repository;

import com.demo.eventmanagement.Event.entity.Event;
import com.demo.eventmanagement.Event.entity.RegisteredEvent;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RegisteredEventRepository extends JpaRepository<RegisteredEvent, Long>{

}
