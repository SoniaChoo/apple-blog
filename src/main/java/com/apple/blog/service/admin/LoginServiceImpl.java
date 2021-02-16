/**
 * @author sonia
 * @description: 登录业务逻辑
 * @date 2021/2/16 10:22
 */
package com.apple.blog.service.admin;

import com.apple.blog.entity.User;
import com.apple.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.List;


@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public  List<User> checkLogin(String username, String password) {
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        HashMap<String, Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",md5Password);
        List<User> users = userMapper.selectByMap(map);
        return users;
    }
}
