/**
 * @author sonia
 * @description: 登录业务逻辑
 * @date 2021/2/16 10:21
 */
package com.apple.blog.service;

import com.apple.blog.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
public interface UserService extends IService<User> {
    List<User> checkLogin(String username, String password);
}
