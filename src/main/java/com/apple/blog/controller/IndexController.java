/**
 * @author sonia
 * @description:test
 * @date 2021/2/10 17:52
 */
package com.apple.blog.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@Controller
public class IndexController {

    @GetMapping("/index")
    public String blogTest() {
//        String blog = null;
//        if (blog == null) {
//            throw new NotfoundException("博客不存在");
//        }
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
