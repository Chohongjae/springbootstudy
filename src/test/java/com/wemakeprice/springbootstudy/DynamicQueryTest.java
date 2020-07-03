package com.wemakeprice.springbootstudy;

import com.querydsl.core.BooleanBuilder;
import com.wemakeprice.springbootstudy.domain.Board;
import com.wemakeprice.springbootstudy.domain.QBoard;
import com.wemakeprice.springbootstudy.persistence.DynamicBoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicQueryTest {
    @Autowired
    DynamicBoardRepository dynamicBoardRepository;

    @Test
    public void testDynamicQuery(){
        String searchCondition = "TITLE";
        String searchKeyword = "z2z";

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QBoard qboard = QBoard.board;

        if (searchCondition.equals("TITLE")){
            booleanBuilder.and(qboard.title.like("%" + searchKeyword + "%"));
        } else if (searchCondition.equals("CONTENT")){
            booleanBuilder.and(qboard.content.like("%" + searchKeyword + "%"));
        }
        PageRequest of = PageRequest.of(0, 5);
        Page<Board> boardPage = dynamicBoardRepository.findAll(booleanBuilder, of);

        for(Board board: boardPage){
            System.out.println(board.toString());
        }
    }
}
