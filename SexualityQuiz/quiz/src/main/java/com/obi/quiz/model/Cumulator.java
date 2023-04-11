package com.obi.quiz.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Cumulator {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String browserSession;
private int cumulative;

    public Cumulator() {
    }

    @Override
    public String toString() {
        return "Cumulator{" +
                "id=" + id +
                ", browserSession='" + browserSession + '\'' +
                ", cumulative=" + cumulative +
                '}';
    }
}
