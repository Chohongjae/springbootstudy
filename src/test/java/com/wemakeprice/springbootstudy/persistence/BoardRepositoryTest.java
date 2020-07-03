package com.wemakeprice.springbootstudy.persistence;

import com.wemakeprice.springbootstudy.domain.Board;
import com.wemakeprice.springbootstudy.domain.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

//    @Test
//    public void testInsertBoard(){
//        Board board = new Board();
//        board.setContent("hi");
//        board.setTitle("zz");
//        board.setWriter("ggew");
//        boardRepository.save(board);
//    }

    @Test
    public void testGetBoard(){
        Optional<Board> board = boardRepository.findById(1L);
        System.out.println(board.get().toString());
    }

//    @Test
//    public void testUpdateBoard(){
//        if (boardRepository.findById(1L).isPresent()){
//            Board board = boardRepository.findById(1L).get();
//            board.setWriter("아아아앙");
//            boardRepository.save(board);
//        }
//    }
//
//    @Test
//    public void testQueryMethod(){
//        for(int i = 0; i < 10; i ++){
//            Board board = new Board();
//            board.setContent("hi");
//            board.setTitle("zz"+i);
//            board.setWriter("ggew");
//            boardRepository.save(board);
//        }
//
//        List<Board> boardList = boardRepository.findByTitle("zz5");
//        System.out.println(boardList.get(0));
//    }
//
//    @Test
//    public void testQueryMethod2(){
//        for(int i = 0; i < 10; i ++){
//            Board board = new Board();
//            board.setContent("hi");
//            board.setTitle("zz"+i);
//            board.setWriter("ggew");
//            boardRepository.save(board);
//        }
//
//        List<Board> boardList = boardRepository.findByTitleContaining("zz");
//        for(Board board: boardList){
//            System.out.println(board.toString());
//        }
//    }

    @Test
    public void testQueryMethod3(){
        List<Board> boardList = boardRepository.findByTitleContainingOrContentContaining("zzass5", "h");
        for(Board board: boardList){
            System.out.println(board.toString());
        }
    }

    @Test
    public void testQueryMethod4(){
        List<Board> boardList = boardRepository.findByTitleContainingOrderBySeqDesc("zz");
        for(Board board: boardList){
            System.out.println(board.toString());
        }
    }

    @Test
    public void testQueryMethod5(){
        PageRequest pageRequest = PageRequest.of(0, 5);
        PageRequest pageRequest2 = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
        List<Board> boardList = boardRepository.findByContentContaining("hi", pageRequest2);
        for(Board board: boardList){
            System.out.println(board.toString());
        }
    }

//    @Test
//    public void testQueryMethod6(){
//        PageRequest pageRequest = PageRequest.of(0, 5);
//        PageRequest pageRequest2 = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
//        Page<Board> boardList = boardRepository.findByWriterContaining("ggew", pageRequest2);
//        System.out.println(boardList.getSize());
//        System.out.println(boardList.getTotalElements());
//        System.out.println(boardList.getTotalPages());
//        System.out.println(boardList.nextPageable());
//    }

//    @Test
//    public void testQueryMethod7(){
//        List<Board> boards = boardRepository.queryAnnotationTest1("zz");
//        for(Board board: boards){
//            System.out.println(board.toString());
//        }
//    }
//
//    @Test
//    public void testQueryMethod8(){
//        List<Board> boards = boardRepository.queryAnnotationTest2("zz");
//        for(Board board: boards){
//            System.out.println(board.toString());
//        }
//    }
//
//    @Test
//    public void testQueryMethod9(){
//        PageRequest pageRequest = PageRequest.of(0, 5);
//        List<Board> boards = boardRepository.queryAnnotationTest3(pageRequest);
//        for(Board board: boards){
//            System.out.println(board.toString());
//        }
//    }
}