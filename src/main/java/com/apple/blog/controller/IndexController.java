/**
 * @author sonia
 * @description:test
 * @date 2021/2/10 17:52
 */
package com.apple.blog.controller;

import com.apple.blog.entity.Blog;
import com.apple.blog.service.BlogService;
import com.apple.blog.service.BlogTagService;
import com.apple.blog.service.TypeService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@Controller
public class IndexController {

    private static final Integer LIMIT = 6;

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;
    @Autowired
    private BlogTagService blogTagService;

    @GetMapping("/")
    public String index(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        Page<Blog> page = new Page<>(pn, LIMIT);
        model.addAttribute("page", blogService.getBlogByPage(page));
        model.addAttribute("types", blogService.getBlogCountByType(LIMIT));
        model.addAttribute("tags", blogTagService.getBlogCountByTag(LIMIT));
        model.addAttribute("recommendBlogs", blogService.getBlogByRecommend(LIMIT));
        return "index";
    }

    @PostMapping("/search")
    public String search(@RequestParam(value = "pn", defaultValue = "1") Integer pn, @RequestParam String query, Model model) {
        model.addAttribute("page", blogService.getBlogByKeyWord(query, pn, LIMIT));
        model.addAttribute("query", query);
        return "search";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable("id") Long id, Model model) {
        model.addAttribute("page", blogService.getById(id));
        return null;
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
