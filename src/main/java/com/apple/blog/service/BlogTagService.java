package com.apple.blog.service;

import com.apple.blog.entity.Blog;
import com.apple.blog.entity.BlogTag;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface BlogTagService extends IService<BlogTag> {
    List<Map<String, Object>> getBlogCountByTag(Integer limit);

    Page<Blog> getBlogByTag(Integer pn, Integer size, Long tagId);
}
