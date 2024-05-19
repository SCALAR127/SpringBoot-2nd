package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class Introduce {

    @GetMapping("/introduceTT" )
    public String into(){
        return "introduce";
    }

    @GetMapping("/introduce")
    @ResponseBody
    public String getName(HttpServletRequest request) {
        return request.getParameter("name");
    }
}

