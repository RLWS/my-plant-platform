package com.rlws.plant.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private int id;
    private String email;
    private String username;
    private String password;
    private int sex;
    private String img;
    private int power;
    private int frequency;

}
