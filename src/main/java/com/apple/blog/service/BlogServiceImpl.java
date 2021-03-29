/**
 * @author sonia
 * @description: 博客业务层
 * @date 2021/2/17 19:24
 */
package com.apple.blog.service;

import com.alibaba.druid.util.StringUtils;
import com.apple.blog.entity.Blog;
import com.apple.blog.entity.Tag;
import com.apple.blog.entity.Type;
import com.apple.blog.mapper.BlogMapper;
import com.apple.blog.mapper.TagMapper;
import com.apple.blog.mapper.TypeMapper;
import com.apple.blog.vo.BlogQuery;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {
    private final static String TYPE_ID = "type_id";
    private final static String TAG_ID = "tag_id";
    private final static String TYPE_COUNT = "count";
    private final static String TYPE_NAME = "name";
    private final static String TAG_NAME = "name";
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Blog> getBlogByBlogQuery(BlogQuery blogQuery) {
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        if (blogQuery.getTypeId() != null) {
            queryWrapper.eq("type_id", blogQuery.getTypeId());
        }
        if (!StringUtils.isEmpty(blogQuery.getTitle())) {
            queryWrapper.like("title", blogQuery.getTitle());
        }
        if (blogQuery.getRecommend() != null) {
            queryWrapper.eq("recommend", blogQuery.getRecommend());
        }
        List<Blog> blogList = blogMapper.selectList(queryWrapper);
        return blogList;
    }

    @Override
    public List<Map<String, Object>> getBlogCountByType(Integer limit) {
        // TODO:后续可以做redis的优化
        List<Map<String, Object>> blogCountByTypeList = blogMapper.getBlogCountByType(limit);
        for (Map<String, Object> blogTypeMap : blogCountByTypeList) {
            Long typeId = (Long) blogTypeMap.get(TYPE_ID);
            Type currentType = typeMapper.selectById(typeId);
            blogTypeMap.put(TYPE_NAME, currentType.getName());
//            // java.lang.Number是Integer,Long的父类
//            Number num = (Number) blogTypeMap.get(TYPE_COUNT);
//            Integer count = 0;
//            if (num != null) {
//                count = num.intValue();
//            }
        }
        return blogCountByTypeList;
    }

    @Override
    public List<Map<String, Object>> getBlogCountByTag(Integer limit) {
        List<Map<String, Object>> blogCountByTagList = blogMapper.getBlogCountByTag(limit);
        for (Map<String, Object> blogTagMap : blogCountByTagList) {
            Long tagId = (Long) blogTagMap.get(TAG_ID);
            Tag currentTag = tagMapper.selectById(tagId);
            blogTagMap.put(TAG_NAME, currentTag.getName());
        }
        return blogCountByTagList;
    }
}
