package com.wemakeprice.springbootstudy.service;

import com.wemakeprice.springbootstudy.domain.BoardVO;

import java.util.List;

public interface BoardService {
    String hello(String name);

    BoardVO getBoard();

    List<BoardVO> getBoardList();
}
