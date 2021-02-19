/**
 * @author sonia
 * @description:
 * @date 2021/2/17 19:22
 */
package com.apple.blog.mapper;

import com.apple.blog.entity.Blog;
import com.apple.blog.vo.BlogQuery;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface BlogMapper extends BaseMapper<Blog> {
}
