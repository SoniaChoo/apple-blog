/**
 * @author sonia
 * @description: 测试mybatis-plus功能
 * @date 2021/2/13 16:00
 */
package com.apple.blog;

import com.apple.blog.entity.Type;
import com.apple.blog.mapper.TypeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestType {
    @Autowired
    private TypeMapper typeMapper;

    @Test
    public void testType() {
    System.out.println("开始测试mybatis******");
        List<Type> types = (List<Type>) typeMapper.selectList(null);
        for (Type type : types) {
            System.out.println(type);
        }
    }
}
