package com.demo.eventmanagement.Registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.eventmanagement.Registration.entity.RegisteredUsers;

@Repository
public interface UserRegisteredRepository extends JpaRepository<RegisteredUsers, Long>{

}
