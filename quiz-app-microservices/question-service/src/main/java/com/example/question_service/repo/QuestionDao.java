package com.example.question_service.repo;

import com.example.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    //find question by category
    List<Question> findByCategory(String category);

    @Query(value = "SELECT q.id FROM question q WHERE q.category =:category ORDER BY RAND() LIMIT :numQuestions", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(@Param("category") String category, @Param("numQuestions") Integer numQuestions);
}
