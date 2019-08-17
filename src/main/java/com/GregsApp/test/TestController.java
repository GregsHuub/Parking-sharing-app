package com.GregsApp.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/main2")
    public String mainTest2(){
        return "index2";
    }
    @GetMapping("/main3")
    public String mainTest3(){
        return "index3";
    }
}
