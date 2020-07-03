package com.wemakeprice.springbootstudy.controller;


import com.wemakeprice.springbootstudy.domain.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// 이 설정은 이제부터는 내장 톰캣을 구동하고 정상적으로 서블릿 컨테이너를 사용하겠다는 설정
// MOCK으로 설정할 경우 모킹된 서블릿 컨테이너를 제공하기 때문에 내장 톰캣이 구동되지 않는다.(기본)
    // AutoConfigureMockMvc 어노테이션을 사용하여 MOCKmvc 객체를 주입받아 테스트에 사용할 수 있다.
// NONE으로 설정할 경우 서블릿 기반의 환경자체를 구성하지 않는다
public class BoardControllerTest3 {
    @Autowired
    private TestRestTemplate testRestTemplate; // 더이상 서블릿 컨테이너를 모킹하지 않기 때문에 MockMvc 객체를 목업할 수 없다. 대신 실제 컨트롤러를 실행해줄 TestRestTemplate 객체를 주입해서 컨트롤러를 요청해야 한다.

    @Test
    public void testHello() throws Exception {
        String result = testRestTemplate.getForObject("/hello?name=둘리", String.class);
        assertEquals("Hello : 둘리", result);
    }

    @Test
    public void testBoardVO() throws Exception {
        BoardVO boardVO = testRestTemplate.getForObject("/getBoard", BoardVO.class);
        assertEquals("geeee", boardVO.getContent());
    }

}