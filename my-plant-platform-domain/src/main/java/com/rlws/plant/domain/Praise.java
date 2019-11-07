package com.rlws.plant.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Praise implements Serializable {
    private int id;
    private int user_id;
    private int answer_id;
}
