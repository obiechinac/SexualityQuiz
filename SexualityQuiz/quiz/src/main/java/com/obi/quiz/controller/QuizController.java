package com.obi.quiz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.obi.quiz.form.QuestionForm;
import com.obi.quiz.form.ReturnMessage;
import com.obi.quiz.model.Cumulator;
import com.obi.quiz.model.Option;
import com.obi.quiz.model.Question;
import com.obi.quiz.repository.OptionRepository;
import com.obi.quiz.service.CumulatorService;
import com.obi.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/quiz/")
public class QuizController {
    @Autowired
    private CumulatorService cumulatorService;
    @Autowired
    private QuestionService questionService;

    @Autowired
    private OptionRepository optionRepository;

    @GetMapping("home")
    public String home(Model model){

//        model.addAttribute()
        return "index";
    }
    @GetMapping("addquestion")
    public String questionForm(Model model){
        model.addAttribute("form", new QuestionForm());
        return "add_question";
    }
    @PostMapping("savequestion")
    public void saveQuestion( @ModelAttribute QuestionForm form){
        Option option = Option.builder()
                .optionAndValue(Map.of(form.getOption(), form.getOptionValue()))
                .build();
        Option opt =optionRepository.save(option);
        Question question = Question.builder()
                .no(form.getNo())
                .slug(form.getSlug())
                .isFinal(form.isFinal())
                .option(Arrays.asList(option))
                .build();
        questionService.save(question);

    }
    @RequestMapping( value = "start/{session}",  produces = "application/json")
    @ResponseBody
    public String startQuiz(@PathVariable("session")String session) throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        Question question = questionService.findByNo(1);
       String json= obj.writeValueAsString(question);
        System.out.println(json);

        return json;
    }

    @RequestMapping( value = "savecumulator/{session}/{cumulative}/{questionNo}",  produces = "application/json")
    @ResponseBody
    public String saveCumulator(@PathVariable("session")String session,
                                @PathVariable("cumulative")int cumulative,
                                @PathVariable("questionNo")Integer questionNo) throws JsonProcessingException {
        Cumulator cum = cumulatorService.findByBrowserSession(session);
        if(cum!=null){
            cum.setCumulative((cum.getCumulative()+cumulative));
            cumulatorService.save(cum);
        }else {
            Cumulator cumulator = Cumulator.builder()
                    .browserSession(session)
                    .cumulative(cumulative)
                    .build();
            cumulatorService.save(cumulator);
        }
        ObjectMapper obj = new ObjectMapper();
        Question question = questionService.findByNo(questionNo+1);
        String json= obj.writeValueAsString(question);
        return json;
    }
    @GetMapping(value = "final/{session}/{cumulative}",  produces = "application/json")
    @ResponseBody
    public String finalConclusion(@PathVariable("session") String session,@PathVariable("cumulative") int cumulative) throws JsonProcessingException {
        System.out.println("calling cumulator by id");
        Cumulator cum = cumulatorService.findByBrowserSession(session);
        System.out.println(cum);
        //clear the record as it will no longer be needed
        cumulatorService.delete(cum);
        ObjectMapper obj = new ObjectMapper();
        ReturnMessage message =cumulatorService.predictSexuality(cum.getCumulative()+cumulative);
        String json= obj.writeValueAsString(message);
        System.out.println(json);
        return json;

    }
}
