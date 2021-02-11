/**
 * @author sonia
 * @description:test
 * @date 2021/2/10 17:52
 */
package com.apple.blog.blogController;

import com.apple.blog.NotfoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@Controller
public class IndexController {

    @GetMapping("/index")
    public String blogTest(@RequestParam("a") int a) {
        String blog = null;
        if (blog == null) {
            throw new NotfoundException("博客不存在");
        }
        return "index";
    }
}
