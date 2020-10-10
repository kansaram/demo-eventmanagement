package com.demo.eventmanagement.Users.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.eventmanagement.Users.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findByEventId(Long eventId);
}