package com.rlws.plant.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVo implements Serializable {

    //根据Id查可用
    private int id;
    //根据List<String>查可以用
    private List<String> strList;

    //根据String查可以用
    private String search;

    private int page_start;
    private int page_size;
    private int page_current;
    private int page_count;

}
