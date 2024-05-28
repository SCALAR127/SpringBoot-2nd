package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class json {
    @GetMapping("json")
    @ResponseBody
    public Test test() {
        Test testJson = new Test();
        testJson.setName("지빈");
        testJson.setAge("20");

        return testJson;

    }
}


