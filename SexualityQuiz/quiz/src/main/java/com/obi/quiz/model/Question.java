package com.obi.quiz.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String slug;

    private int no;

    private boolean isFinal;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "option_id")
    private List<Option> option;

    public Question() {
    }

    public Question(String slug, int no, boolean isFinal, List<Option> option) {
        this.slug = slug;
        this.no = no;
        this.isFinal = isFinal;
        this.option = option;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", slug='" + slug + '\'' +
                ", no=" + no +
                ", isFinal=" + isFinal +
                ", option=" + option +
                '}';
    }
}
