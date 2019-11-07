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
public class Message implements Serializable {
    private int id;
    private String content;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date time;
    private int user_id_j;
    private int user_id_f;
    private int handle;
    private User user_f;
    private User user_j;
}
