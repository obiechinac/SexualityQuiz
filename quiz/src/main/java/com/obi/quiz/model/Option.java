package com.obi.quiz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

//    @MapKeyColumn(name="option_value")
    @ElementCollection
    private Map<String, Integer> optionAndValue ;

   public Option(){}

    public Option(Map<String, Integer> optionAndValue) {
        this.optionAndValue = optionAndValue;
    }

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", optionAndValue=" + optionAndValue +
                '}';
    }
}
