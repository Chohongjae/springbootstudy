package com.wemakeprice.springbootstudy.controller;


import com.wemakeprice.springbootstudy.service.BoardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc // 얘는 controller뿐만아니라 service나 repository가 붙은 객체들도 메모리에 올린다.
// 따라서 간단하게 컨트롤러만 테스트하기위해서는 webmvctest를 사용한다.
// WebMvcTest와 SpringbootTest는 같이 사용될 수 없다.
// MockMvc 객체를 목업하기 위해서 사용
public class BoardControllerTest2 {
    @Autowired
    private MockMvc mockMvc; //@controller에 대한 테스트 코드를 작성할 수 있다.

    @MockBean // 해당 타입의 객체를 모킹할수있다. 예를들어 실제 서비스를 불러오는데 많은 리소스를 사용하거나 아직 구현이 안되어있을때 이런식으로 사용 when으로 결과를 정해두고
    private BoardService boardService;

    @Test
    public void testHello() throws Exception {
        when(boardService.hello("둘리")).thenReturn("Hello : 둘리");

        mockMvc.perform(get("/hello").param("name", "둘리"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello : 둘리"))
                .andDo(print());
    }

}