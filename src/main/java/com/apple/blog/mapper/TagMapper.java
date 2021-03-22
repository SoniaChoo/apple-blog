/**
 * @author sonia
 * @description: 标签mapper
 * @date 2021/2/19 16:24
 */
package com.apple.blog.mapper;

import com.apple.blog.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper extends BaseMapper<Tag> {
}
