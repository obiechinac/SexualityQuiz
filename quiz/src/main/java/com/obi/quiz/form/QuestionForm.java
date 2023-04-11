package com.obi.quiz.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class QuestionForm {

    private String slug;

    private int no;
    private String option;
    private Integer optionValue;
    private boolean isFinal;

    public QuestionForm() {
    }
}
