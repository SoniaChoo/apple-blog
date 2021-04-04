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
    @Select("select type_id, count(type_id) as count from t_blog group by type_id order by count desc limit #{limit}")
    List<Map<String, Object>> getBlogCountByType(@Param("limit") Integer limit);

    @Select("select * from t_blog where recommend = true order by update_time desc limit #{limit}")
    List<Blog> getBlogByRecommend(Integer limit);
}
