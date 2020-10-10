package com.demo.eventmanagement.Event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.eventmanagement.Event.entity.EventDetails;

@Repository
public interface EventDetailRepository extends JpaRepository<EventDetails, Long>{

}
