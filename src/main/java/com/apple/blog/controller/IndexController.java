/**
 * @author sonia
 * @description:test
 * @date 2021/2/10 17:52
 */
package com.apple.blog.controller;

import com.apple.blog.entity.Blog;
import com.apple.blog.service.BlogService;
import com.apple.blog.service.TypeService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@Controller
public class IndexController {

    private static final Integer LIMIT = 6;

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/index")
    public String index(@RequestParam(value = "page", defaultValue = "1") Integer pn, Model model) {
        Page<Blog> page = new Page<>(pn, LIMIT);
        model.addAttribute("page", blogService.getBlogByPage(page));
        model.addAttribute("types", blogService.getBlogCountByType(LIMIT));
        model.addAttribute("tags", blogService.getBlogCountByTag(LIMIT));
        model.addAttribute("recommendBlogs",blogService.getBlogByRecommend(LIMIT));
        return "index";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/archives")
    public String archives() {
        return "archives";
    }

    @GetMapping("/tags")
    public String tags() {
        return "tags";
    }

    @GetMapping("/types")
    public String types() {
        return "types";
    }
}
