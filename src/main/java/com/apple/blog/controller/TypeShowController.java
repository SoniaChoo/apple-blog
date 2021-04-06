package com.apple.blog.controller;

import com.apple.blog.entity.Blog;
import com.apple.blog.service.BlogService;
import com.apple.blog.service.TypeService;
import com.apple.blog.vo.BlogQuery;
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
public class TypeShowController {
    private final static String TYPE_ID = "type_id";
    private final static Integer LIMIT = 6;
    @Autowired
    private BlogService blogService;

    @GetMapping("/types/{id}")
    public String types(@RequestParam(value = "pn",defaultValue = "1") Integer pn, @PathVariable Long id, Model model) {
        List<Map<String, Object>> types = blogService.getBlogCountByType(100000);
        if (id == -1) {
            id = (Long) types.get(0).get(TYPE_ID);
        }
        BlogQuery blogQuery = new BlogQuery();
        blogQuery.setTypeId(id);
        Page<Blog> blogPage = blogService.getBlogByBlogQuery(blogQuery,pn,LIMIT);
        List<Blog> blogList = blogPage.getRecords();
        blogList = blogService.setUserAndTagAndTypeWithBlog(blogList);
        blogPage.setRecords(blogList);
        model.addAttribute("types",types);
        model.addAttribute("page",blogPage);
        model.addAttribute("activeTypeId",id);
        return "types";
    }
}
