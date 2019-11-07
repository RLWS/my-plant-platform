package com.rlws.plant.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collect implements Serializable {

    private int id;
    private int user_id;
    private int question_id;
    private Question question;

}
