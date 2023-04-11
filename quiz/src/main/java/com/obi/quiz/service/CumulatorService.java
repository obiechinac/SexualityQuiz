package com.obi.quiz.service;

import com.obi.quiz.form.ReturnMessage;
import com.obi.quiz.model.Cumulator;
import com.obi.quiz.repository.CumulatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CumulatorService {

    @Autowired
    private CumulatorRepository cumulatorRepository;

    public Cumulator save(Cumulator cumulator){
//        int initial
//        Cumulator cumulator_ = cumulatorRepository.findByBrowserSession(session);

//Cumulator cumulator = Cumulator.builder()
//        .cumulative(12)
//        .browserSession(session)
//        .build();
        return cumulatorRepository.save(cumulator);
    }

    public Cumulator findByBrowserSession(String session){

        return cumulatorRepository.findByBrowserSession(session);
    }

    public ReturnMessage predictSexuality(int cumulative){
        String finalmessage="You are as straight as arrow";
ReturnMessage message = new ReturnMessage();
        if (cumulative>=20){

           finalmessage= "You are gay! you should probably be honest about it";
        } if (cumulative<10){

            finalmessage= "You are Straight as an arrow! ";
        }
        if (cumulative>=10&cumulative<=15){

            finalmessage= "You are mostly straight! with some elements of curiosity";
        }if (cumulative>=15&cumulative<20){

            finalmessage= "You are bisexual/curious! opening yourself up a little more would give you a better understanding of your sexuality";
        }
        message.setMessage(finalmessage);
        return message;
    }

    public void delete(Cumulator cum) {
        cumulatorRepository.delete(cum);
    }
}
