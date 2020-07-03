package com.wemakeprice.springbootstudy.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest // @controller, @Restcontroller가 설정된 클래스들을 찾아 메모리에 생성한다. 반면에 @service, @repository등은 테스드 대상이 아닌것으로 간주하고 생성하지 않는다.
public class BoardControllerTest {
    @Autowired
    private MockMvc mockMvc; //@controller에 대한 테스트 코드를 작성할 수 있다.

    @Test
    public void testHello() throws Exception {
        mockMvc.perform(get("/hello").param("name", "둘리"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello : 둘리"))
                .andDo(print());
    }

}