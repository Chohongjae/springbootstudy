package com.wemakeprice.springbootstudy.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @Column(name="MEMBER_ID")
    private String id;
    private String password;
    private String name;
    private String role;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Board> boardList = new ArrayList<>();

    /*
     MANY쪽이 OWNER 이며 mappedBy는 @OneToMany쪽의 컬렉션 칼럼에 기술하여 OWNER가 아님을 정의한다.
    mappdBy는 @OneToOne, @OneToMany, @ManyToMany 어노테이션에서 사용할 수 있으며 mappedBy가 없으면 JAP에서 양뱡향 관계라는 것을 모르고 두 엔티티의 매핑 테이블을 생성한다.
    mappedBy는 OWBER 엔티티의 필드나 속성과 대응된다.
    ManyToOne 양방향 관계에서 Many측에는 mappedBy요소를 사용할 수 없다.(MANY 쪽이 OWNER)
     */
}
