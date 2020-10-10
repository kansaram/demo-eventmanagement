package com.demo.eventmanagement.Feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.eventmanagement.Feedback.event.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
