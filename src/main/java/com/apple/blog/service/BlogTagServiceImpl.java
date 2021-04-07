package com.apple.blog.service;

import com.apple.blog.entity.Blog;
import com.apple.blog.entity.BlogTag;
import com.apple.blog.entity.Tag;
import com.apple.blog.mapper.BlogMapper;
import com.apple.blog.mapper.BlogTagMapper;
import com.apple.blog.mapper.TagMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BlogTagServiceImpl extends ServiceImpl<BlogTagMapper, BlogTag> implements BlogTagService {
    private static final String TAG_ID = "tag_id";
    private static final String TAG_NAME = "name";
    @Autowired
    private BlogTagMapper blogTagMapper;
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private BlogService blogService;

    @Override
    public List<Map<String, Object>> getBlogCountByTag(Integer limit) {
        List<Map<String, Object>> blogCountByTagList = blogTagMapper.getBlogCountByTag(limit);
        for (Map<String, Object> blogTagMap : blogCountByTagList) {
            Long tagId = (Long) blogTagMap.get(TAG_ID);
            Tag currentTag = tagMapper.selectById(tagId);
            blogTagMap.put(TAG_NAME, currentTag.getName());
        }
        return blogCountByTagList;
    }

    @Override
    public Page<Blog> getBlogByTag(Integer pn, Integer size, Long tagId) {
        List<Long> blogIdList = blogTagMapper.getBlogIdByTagId(tagId);
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", blogIdList);
        Page<Blog> page = new Page<>();
        Page<Blog> blogPage = blogService.page(page, queryWrapper);
        List<Blog> blogList = blogPage.getRecords();
        blogList = blogService.setUserAndTagAndTypeWithBlog(blogList);
        blogPage.setRecords(blogList);
        return blogPage;
    }
}
