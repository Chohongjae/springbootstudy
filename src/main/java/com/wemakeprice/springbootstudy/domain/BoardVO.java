package com.wemakeprice.springbootstudy.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BoardVO {
    private int seq;
    private String title;
    private String writer;
    private String content;
    private Date createDate = new Date();
    private int cnt;


}
