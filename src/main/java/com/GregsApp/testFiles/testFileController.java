package com.GregsApp.testFiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class testFileController {

    private TestService testService;

    @Autowired
    public testFileController(TestService testService) {
        this.testService = testService;
    }
    @GetMapping("/uploadImageForm")
    public String uploadImageForm(){
        return "test/upload_file_test";
    }

    @PostMapping("/uploadImage")
    @ResponseBody
    public String uploadImage(@RequestParam("imageFile")MultipartFile imageFile) throws IOException {
    testService.saveImage(imageFile);
    return "udalo sie";

    }

}

