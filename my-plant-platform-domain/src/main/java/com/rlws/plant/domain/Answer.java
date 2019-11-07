package com.rlws.plant.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer implements Serializable {
    private int id;
    private String  content;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date time;
    private int praise;
    private int user_id;
    private int question_id;
    private User user;
    private List<Reply> replyList;

}
