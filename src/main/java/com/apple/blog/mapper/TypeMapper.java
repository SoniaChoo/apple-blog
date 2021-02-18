/**
 * @author sonia
 * @description: some desc
 * @date 2021/2/13 15:59
 */
package com.apple.blog.mapper;

import com.apple.blog.entity.Type;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TypeMapper extends BaseMapper<Type> {
}
