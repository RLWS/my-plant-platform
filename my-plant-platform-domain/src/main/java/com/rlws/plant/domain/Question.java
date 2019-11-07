package com.rlws.plant.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question implements Serializable {
    private int id;
    private String title;
    private String content;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date time;
    private int praise;
    private int category_id;
    private int user_id;
    private int optimal;
    private int urgent;
    private User user;
    private Category category;
}
