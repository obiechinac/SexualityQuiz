package com.obi.quiz.clrunner;

import com.obi.quiz.model.Option;
import com.obi.quiz.model.Question;
import com.obi.quiz.repository.OptionRepository;
import com.obi.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class Run implements CommandLineRunner {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private OptionRepository optionRepository;

    // this class runs immediately the app starts
    @Override
    public void run(String... args) throws Exception {
        List<Option> q1_option = new ArrayList<>();
        Option option1 = new Option(Map.of("No never! I would never do such",1));
        Option option1_ = optionRepository.save(option1);
        Option option2 = new Option(Map.of("No but I could try that",3));
        Option option2_ = optionRepository.save(option2);
        Option option3 = new Option(Map.of("Yes and it felt good",5));
        Option option3_ = optionRepository.save(option3);
        Option option4 =new Option(Map.of("Yes but I would not do it again",2));
        Option option4_ = optionRepository.save(option4);
        q1_option.add(option1_);
        q1_option.add(option2_);
        q1_option.add(option3_);
        q1_option.add(option4_);
        Question q1 = new Question("Have you kissed someone of same gender before?",1,false,q1_option);
       Question question= questionService.save(q1);
        System.out.println(question.toString());

        //second question
        List<Option> q2_option = new ArrayList<>();
        Option option12 = new Option(Map.of("No I never did! ",0));
        Option option1_2 = optionRepository.save(option12);
        Option option22 = new Option(Map.of("No but I see it as normal thing",1));
        Option option2_2 = optionRepository.save(option22);
        Option option32 = new Option(Map.of("Yes and it felt good",2));
        Option option3_2 = optionRepository.save(option32);
        Option option42 =new Option(Map.of("Yes and I still have on someone now",3));
        Option option4_2 = optionRepository.save(option42);
        q2_option.add(option1_2);
        q2_option.add(option2_2);
        q2_option.add(option3_2);
        q2_option.add(option4_2);
        Question q2 = new Question("Have you had crush on someone of same gender before?",2,false,q2_option);
        Question question2= questionService.save(q2);
        System.out.println(question2.toString());

        //third question
        List<Option> q3_option = new ArrayList<>();
        Option option13 = new Option(Map.of("Oh, I’ve totally watched shows just for the queer ships and storylines! ",2));
        Option option1_3 = optionRepository.save(option13);
        Option option23 = new Option(Map.of("I kind of feel like I can identify with queer characters.",3));
        Option option2_3 = optionRepository.save(option23);
        Option option33= new Option(Map.of("I notice queer characters, but I don’t feel strongly about them.",0));
        Option option3_3 = optionRepository.save(option33);
        Option option43 =new Option(Map.of("I like the positive representation, but they don’t stand out to me",1));
        Option option4_3 = optionRepository.save(option43);
        q3_option.add(option1_3);
        q3_option.add(option2_3);
        q3_option.add(option3_3);
        q3_option.add(option4_3);
        Question q3 = new Question("How do you feel about queer characters in TV shows and movies?",3,false,q3_option);
        Question question3= questionService.save(q3);
        System.out.println(question3.toString());

        //fourth question
        List<Option> q4_option = new ArrayList<>();
        Option option14 = new Option(Map.of("Strongly Agree! ",5));
        Option option1_4 = optionRepository.save(option14);
        Option option24 = new Option(Map.of("Strongly Disagree",0));
        Option option2_4 = optionRepository.save(option24);
        Option option34 = new Option(Map.of("agree",2));
        Option option3_4 = optionRepository.save(option34);
        Option option44 =new Option(Map.of("disagree",2));
        Option option4_4 = optionRepository.save(option44);
        q4_option.add(option1_4);
        q4_option.add(option2_4);
        q4_option.add(option3_4);
        q4_option.add(option4_4);
        Question q4 = new Question("Organizations which promote gay rights are necessary.",4,false,q4_option);
        Question question4= questionService.save(q4);
        System.out.println(question4.toString());

        //fifth question
        List<Option> q5_option = new ArrayList<>();
        Option option15 = new Option(Map.of("Not at all! ",0));
        Option option1_5 = optionRepository.save(option15);
        Option option25 = new Option(Map.of("probable yes",2));
        Option option2_5 = optionRepository.save(option25);
        Option option35 = new Option(Map.of("Yes definitely",5));
        Option option3_5 = optionRepository.save(option35);
        Option option45 =new Option(Map.of("I would if they have changed",1));
        Option option4_5 = optionRepository.save(option45);
        q5_option.add(option1_5);
        q5_option.add(option2_5);
        q5_option.add(option3_5);
        q5_option.add(option4_5);
        Question q5 = new Question("I can date someone who is bisexual?",5,false,q5_option);
        Question question5= questionService.save(q5);
        System.out.println(question5.toString());

        //sixth question
        List<Option> q6_option = new ArrayList<>();
        Option option16 = new Option(Map.of("Not at all! ",0));
        Option option1_6 = optionRepository.save(option16);
        Option option26 = new Option(Map.of("probable yes",2));
        Option option2_6 = optionRepository.save(option26);
        Option option36 = new Option(Map.of("Yes definitely",5));
        Option option3_6 = optionRepository.save(option36);
        Option option46=new Option(Map.of("I would if they have changed",1));
        Option option4_6 = optionRepository.save(option46);
        q6_option.add(option1_6);
        q6_option.add(option2_6);
        q6_option.add(option3_6);
        q6_option.add(option4_6);
        Question q6 = new Question("I can date someone who is bisexual?",6,false,q6_option);
        Question question6= questionService.save(q6);
        System.out.println(question6.toString());

        //seventh question
        List<Option> q7_option = new ArrayList<>();
        Option option17 = new Option(Map.of("Not a chance! ",0));
        Option option1_7 = optionRepository.save(option17);
        Option option27 = new Option(Map.of("Probably yes",2));
        Option option2_7 = optionRepository.save(option27);
        Option option37 = new Option(Map.of("Yes definitely",5));
        Option option3_7 = optionRepository.save(option37);
        Option option47 =new Option(Map.of("I wouldn't mind",2));
        Option option4_7 = optionRepository.save(option47);
        q7_option.add(option1_7);
        q7_option.add(option2_7);
        q7_option.add(option3_7);
        q7_option.add(option4_7);
        Question q7 = new Question("I would get a full body nude oil massage from a person of same gender",7,false,q7_option);
        Question question7= questionService.save(q7);
        System.out.println(question7.toString());

     //eighth question
     List<Option> q8_option = new ArrayList<>();
     Option option18 = new Option(Map.of("No, they just assume I'm straight and this makes me angry ",5));
     Option option1_8 = optionRepository.save(option18);
     Option option28 = new Option(Map.of("Yes! on few occasions and I get pissed ",0));
     Option option2_8 = optionRepository.save(option28);
     Option option38 = new Option(Map.of("Yes sometimes and I don't mind",2));
     Option option3_8 = optionRepository.save(option38);
     Option option48 =new Option(Map.of("No but I wish they did",3));
     Option option4_8 = optionRepository.save(option48);
     q8_option.add(option1_8);
     q8_option.add(option2_8);
     q8_option.add(option3_8);
     q8_option.add(option4_8);
     Question q8 = new Question("People ask me if I am gay",8,false,q8_option);
     Question question8= questionService.save(q8);
     System.out.println(question8.toString());

     //ninth question
     List<Option> q9_option = new ArrayList<>();
     Option option19 = new Option(Map.of("Yes and I was like WTF!",0));
     Option option1_9 = optionRepository.save(option19);
     Option option29 = new Option(Map.of("Yes and i felt like it should be me",5));
     Option option2_9 = optionRepository.save(option29);
     Option option39 = new Option(Map.of("No, not really but I wouldn't care",1));
     Option option3_9 = optionRepository.save(option39);
     Option option49 =new Option(Map.of("No but I would be encouraged if I saw any",3));
     Option option4_9 = optionRepository.save(option49);
     q9_option.add(option1_9);
     q9_option.add(option2_9);
     q9_option.add(option3_9);
     q9_option.add(option4_9);
     Question q9 = new Question("Have you seen intimate gay couple in public?",9,false,q9_option);
     Question question9= questionService.save(q9);
     System.out.println(question9.toString());

     //tenth question
     List<Option> q10_option = new ArrayList<>();
     Option option110 = new Option(Map.of("I would gladly accept it",3));
     Option option1_10 = optionRepository.save(option110);
     Option option210 = new Option(Map.of("I would politely reject it",0));
     Option option2_10 = optionRepository.save(option210);
     Option option310 = new Option(Map.of("I would accept it but dispose it almost instantly",1));
     Option option3_10 = optionRepository.save(option310);
     Option option410 =new Option(Map.of("I will accept it and tape it to my phone",5));
     Option option4_10 = optionRepository.save(option410);
     q10_option.add(option1_10);
     q10_option.add(option2_10);
     q10_option.add(option3_10);
     q10_option.add(option4_10);
     Question q10 = new Question("You come out of the mall and you're offered a rainbow/pride phone sticker",10,true,q10_option);
     Question question10= questionService.save(q10);
     System.out.println(question10.toString());

    }


}
