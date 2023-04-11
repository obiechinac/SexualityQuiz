package com.obi.quiz.service;


import com.obi.quiz.model.Question;
import com.obi.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {
        @Autowired
    private QuestionRepository questionRepository;

        public Question save(Question question){
           return questionRepository.save(question);
        }

        public Optional<Question> findById(Integer id){

            return Optional.of(questionRepository.findById(id).orElseThrow());
        }

        public Question findByNo(Integer no){

            return questionRepository.findByNo(no);
        }
}
