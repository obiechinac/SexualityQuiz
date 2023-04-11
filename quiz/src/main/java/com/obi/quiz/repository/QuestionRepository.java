package com.obi.quiz.repository;

import com.obi.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository  extends JpaRepository<Question, Integer> {

    @Query("from Question q where q.no=:no")
    Question findByNo(Integer no);
}
