/**
 * @author sonia
 * @description: 登录业务逻辑
 * @date 2021/2/16 10:21
 */
package com.apple.blog.service;

import com.apple.blog.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> checkLogin(String username, String password);
}
