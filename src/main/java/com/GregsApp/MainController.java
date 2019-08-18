package com.GregsApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/main")
    public String mainPage(){
        return "index2";
    }
    @GetMapping("/about")
    public String aboutPage(){
        return "about";
    }
    @GetMapping("/404")
    public String errorPage(){
        return "404";
    }
    @GetMapping("/faq")
    public String faq(){
        return "faq";
    }
    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
    @GetMapping("/gallery")
    public String gallery(){
        return "gallery";
    }
    @GetMapping("/blog_main")
    public String blok(){
        return "article";
    }
    @GetMapping("blog_details")
    public String blogDetails(){
        return "article-details";
    }


}
