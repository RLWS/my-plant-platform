package com.rlws.plant.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply implements Serializable {
    private int id;
    private String content;
    private Date time;
    private int user_id;
    private int answer_id;
    private User user;

}
