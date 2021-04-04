package com.apple.blog.mapper;

import com.apple.blog.entity.BlogTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface BlogTagMapper extends BaseMapper<BlogTag> {
    @Select("select tag_id,count(tag_id) as count from t_blog_tag group by tag_id order by count desc limit #{limit}")
    List<Map<String, Object>> getBlogCountByTag(@Param("limit") Integer limit);
}
