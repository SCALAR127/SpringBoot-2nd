package com.example.demo.controller;

import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
public class ArticlesController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    public String viewArticles(Model model){
        model.addAttribute("articles", articleService.findAll());
        return "articles";
    }
}
