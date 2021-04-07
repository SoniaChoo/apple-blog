package com.apple.blog.controller;

import com.apple.blog.entity.Blog;
import com.apple.blog.service.BlogTagService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Component
@Controller
public class TagShowController {
    private static final String TAG_ID = "tag_id";
    private static final Integer LIMIT = 6;
    @Autowired
    private BlogTagService blogTagService;

    @GetMapping("/tags/{id}")
    public String tags(@RequestParam(value = "pn", defaultValue = "1") Integer pn, @PathVariable Long id, Model model) {
        List<Map<String, Object>> tags = blogTagService.getBlogCountByTag(10000);
        if (id == -1) {
            id = (Long) tags.get(0).get(TAG_ID);
        }
        Page<Blog> blogPage = blogTagService.getBlogByTag(pn, LIMIT, id);
        model.addAttribute("tags", tags);
        model.addAttribute("page", blogPage);
        model.addAttribute("activeTagId", id);
        return "tags";
    }
}
