/**
 * @author sonia
 * @description: 博客业务层
 * @date 2021/2/17 19:24
 */
package com.apple.blog.service;

import com.alibaba.druid.util.StringUtils;
import com.apple.blog.entity.Blog;
import com.apple.blog.mapper.BlogMapper;
import com.apple.blog.vo.BlogQuery;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public List<Blog> getBlogByBlogQuery(BlogQuery blogQuery) {
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        if (blogQuery.getTypeId() != null) {
            queryWrapper.eq("type_id",blogQuery.getTypeId());
        }
        if (!StringUtils.isEmpty(blogQuery.getTitle())) {
            queryWrapper.like("title",blogQuery.getTitle());
        }
        if (blogQuery.getRecommend() != null) {
            queryWrapper.eq("recommend",blogQuery.getRecommend());
        }
        List<Blog> blogList = blogMapper.selectList(queryWrapper);
        return blogList;
    }
}
