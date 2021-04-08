package com.apple.blog.controller;

import com.apple.blog.entity.Blog;
import com.apple.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;


@Controller
public class ArchiveShowController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archives(Model model) {
        model.addAttribute("blogMap",blogService.archiveBlog());
        model.addAttribute("count",blogService.countBlog());
        return "archives";
    }
}
