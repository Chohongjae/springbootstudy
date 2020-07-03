package com.wemakeprice.springbootstudy.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class Board {
    @Id
    @GeneratedValue
    private Long seq;
    private String title;
    //    private String writer;
    private String content;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createDate = new Date();
    private Long cnt;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    private Member member;

    public void setMember(Member member) {
        this.member = member;
        this.member.getBoardList().add(this);
    }
}
//QueryDSL은 일종의 JPQL 빌더
