package com.wemakeprice.springbootstudy.persistence;

import com.wemakeprice.springbootstudy.domain.Board;
import com.wemakeprice.springbootstudy.domain.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void testManyToOne() {
        Member member = new Member();
        member.setId("1");
        member.setName("홍제");
        member.setPassword("123");
        member.setRole("USER");


        Member member2 = new Member();
        member2.setId("2");
        member2.setName("케빈");
        member2.setPassword("123");
        member2.setRole("ADMIN");


        for (int i = 0; i <= 10; i++) {
            Board board = new Board();
            board.setTitle("zzzz");
            board.setContent("vvvv");
            if (i < 5){
                board.setMember(member);
            } else{
                board.setMember(member2);
            }
        }
        // member가 저장되면 보드도 저장된다.
        memberRepository.save(member);
        memberRepository.save(member2);
    }

    @Test
    public void testGetBoard(){
        // nullable에 따라 inner join 일지 outer join일지가 변한다. inner join이 더 성능이 좋다.
        Board board = boardRepository.findById(1L).get();
        System.out.println(board.getMember().getName());
        System.out.println(board.getContent());
    }

    @Test
    public void testTwoWayMapping(){
        Member member = memberRepository.findById("1").get();
        List<Board> boardList = member.getBoardList();
        for(Board board: boardList){
            System.out.println(board.toString());
        }
    }

    @Test
    public void testDeleteMember(){
        memberRepository.deleteById("1");
    }

}