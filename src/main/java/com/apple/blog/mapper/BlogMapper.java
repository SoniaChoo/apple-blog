/**
 * @author sonia
 * @description:
 * @date 2021/2/17 19:22
 */
package com.apple.blog.mapper;

import com.apple.blog.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface BlogMapper extends BaseMapper<Blog> {
    @Select("select tag_id, count(tag_id) as count from t_blog group by tag_id order by count desc limit = #{limit}")
    List<Map<String, Object>> getBlogCountByType(@Param("limit") Integer limit);

    @Select("select tag_id,count(tag_id) as cpunt from t_blog group by tag_id order by count desc limit = #{limit}")
    List<Map<String, Object>> getBlogCountByTag(@Param("limit") Integer limit);
}