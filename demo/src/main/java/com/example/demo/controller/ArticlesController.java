package com.example.demo.controller;

import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArticlesController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/posts")
    public String viewArticles(Model model, @RequestParam Long boardId) {
        model.addAttribute("articles", articleService.findBoardId(boardId));
        return "articles";
    }
}
