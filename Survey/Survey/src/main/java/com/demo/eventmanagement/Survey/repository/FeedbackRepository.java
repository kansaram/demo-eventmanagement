package com.demo.eventmanagement.Survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.eventmanagement.Survey.entity.QuestionBank;

public interface FeedbackRepository extends JpaRepository<QuestionBank, Long>{

}
