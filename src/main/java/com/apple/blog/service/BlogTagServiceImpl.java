package com.apple.blog.service;

import com.apple.blog.entity.BlogTag;
import com.apple.blog.mapper.BlogTagMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BlogTagServiceImpl extends ServiceImpl<BlogTagMapper, BlogTag> implements BlogTagService {
}
