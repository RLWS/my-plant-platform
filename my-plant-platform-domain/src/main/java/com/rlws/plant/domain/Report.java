package com.rlws.plant.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report implements Serializable {
    private int id;
    private String content;
    private int user_id;
    private int question_id;
    private int answer_id;
    private User user;
    private Question question;
    private Answer answer;

}
