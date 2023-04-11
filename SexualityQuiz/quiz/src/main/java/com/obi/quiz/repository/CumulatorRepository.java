package com.obi.quiz.repository;

import com.obi.quiz.model.Cumulator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CumulatorRepository extends JpaRepository<Cumulator,Integer> {
    @Query("from Cumulator c where c.browserSession=:session")
    Cumulator findByBrowserSession(String session);
}
