package com.wemakeprice.springbootstudy;


import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"author.name=HELLO WORLD"})
public class PropertiesTest {
    @Autowired
    Environment environment;

    @Test
    public void testMethod(){
        System.out.println(environment.getProperty("author.name"));
        System.out.println(environment.getProperty("author.nation"));
    }
}
