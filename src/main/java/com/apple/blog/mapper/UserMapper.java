/**
 * @author sonia
 * @description:
 * @date 2021/2/16 10:58
 */
package com.apple.blog.mapper;

import com.apple.blog.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
