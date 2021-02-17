/**
 * @author sonia
 * @description: 登录验证
 * @date 2021/2/15 20:24
 */
package com.apple.blog.controller.admin;

import com.apple.blog.entity.User;
import com.apple.blog.exception.UserTooManyException;
import com.apple.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String loginPage() {
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes redirectAttributes) {
        List<User> users = userService.checkLogin(username, password);
        if (users.size() == 0) {
            redirectAttributes.addFlashAttribute("message","用户名或者账号错误");
            return "redirect:/admin";
        }else if (users.size() > 1) {
            throw new UserTooManyException("用户不唯一错误");
        }
        User user = users.get(0);
        user.setPassword(null);
        session.setAttribute("loginUser",user);
        return "admin/index";
    }

    @GetMapping("/logout")
    public String loginOut(HttpSession session) {
        session.removeAttribute("loginUser");
        return "redirect:/admin";
    }
}
