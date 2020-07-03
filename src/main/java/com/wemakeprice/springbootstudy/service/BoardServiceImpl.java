package com.wemakeprice.springbootstudy.service;

import com.wemakeprice.springbootstudy.domain.BoardVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Override
    public String hello(String name) {
        return "Hello : " + name;
    }

    @Override
    public BoardVO getBoard() {
        BoardVO boardVO = new BoardVO();
        boardVO.setContent("geeee");
        boardVO.setTitle("bye");
        boardVO.setWriter("zzzz");
        return boardVO;
    }

    @Override
    public List<BoardVO> getBoardList() {
        List<BoardVO> boardVOList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            BoardVO boardVO = new BoardVO();
            boardVO.setContent("hi");
            boardVO.setTitle("bye");
            boardVO.setWriter("zzzz");
            boardVOList.add(boardVO);
        }
        return boardVOList;
    }
}
