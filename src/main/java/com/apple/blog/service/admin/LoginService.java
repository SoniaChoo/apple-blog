/**
 * @author sonia
 * @description: 登录业务逻辑
 * @date 2021/2/16 10:21
 */
package com.apple.blog.service.admin;

import com.apple.blog.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoginService {
    List<User> checkLogin(String username, String password);
}
