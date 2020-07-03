package com.wemakeprice.springbootstudy.controller;

import com.wemakeprice.springbootstudy.domain.BoardVO;
import com.wemakeprice.springbootstudy.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {
    @Autowired
    BoardService boardService;

    public BoardController() {
        System.out.println("Board Conrtooller 생성");
    }

    @GetMapping("/hello")
    public String hello(String name) {
        return boardService.hello(name);
    }

    @GetMapping("/getBoard")
    public BoardVO getBoard() {
        return boardService.getBoard();
    }

    @GetMapping("/getBoardList")
    public List<BoardVO> getBoardList() {
        return boardService.getBoardList();
    }
}
