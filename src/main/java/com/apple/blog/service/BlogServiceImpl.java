/**
 * @author sonia
 * @description: 博客业务层
 * @date 2021/2/17 19:24
 */
package com.apple.blog.service;

import com.alibaba.druid.util.StringUtils;
import com.apple.blog.entity.*;
import com.apple.blog.mapper.BlogMapper;
import com.apple.blog.mapper.TagMapper;
import com.apple.blog.mapper.TypeMapper;
import com.apple.blog.vo.BlogQuery;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {
    private final static String TYPE_ID = "type_id";
    private final static String TAG_ID = "tag_id";
    private final static String TYPE_COUNT = "count";
    private final static String TYPE_NAME = "name";
    private final static String TAG_NAME = "name";
    private final static String FILE_SEGMENTATION = ",";
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private BlogService blogService;
    @Autowired
    private UserService userService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
    @Autowired
    private BlogTagService blogTagService;

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
        blogCountByTypeList.stream().forEachOrdered(blogTypeMap -> {
            Long typeId = (Long) blogTypeMap.get(TYPE_ID);
            Type currentType = typeMapper.selectById(typeId);
            blogTypeMap.put(TYPE_NAME, currentType.getName());
            // java.lang.Number是Integer,Long的父类
//            Number num = (Number) blogTypeMap.get(TYPE_COUNT);
//            Integer count = 0;
//            if (num != null) {
//                count = num.intValue();
//            }
        });
        return blogCountByTypeList;
    }

    @Override
    public List<Blog> getBlogByRecommend(Integer limit) {
        return blogMapper.getBlogByRecommend(limit);
    }

    @Override
    public List<Blog> getBlogListByTop(Integer limit) {
        return null;
    }

    @Override
    public Page<Blog> getBlogByPage(Page page) {
        Page blogPage = blogService.page(page);
        List<Blog> blogList = blogPage.getRecords();
        // 对user进行赋值
        blogList = blogService.setUserByBlogList(blogList);
        blogPage.setRecords(blogList);
        return blogPage;
    }

    @Override
    public List<Blog> setUserByBlogList(List<Blog> blogList) {
        blogList.stream().forEach(blog -> {
            User blogUser = new User();
            Type blogType = new Type();
            List<Tag> tagList = new ArrayList<>();
            if (blog.getUserId() != null) {
                blogUser = userService.getById(blog.getUserId());
            }
            if (blog.getTypeId() != null) {
                blogType = typeService.getById(blog.getTypeId());
            }
            if (!StringUtils.isEmpty(blog.getTagsId())) {
                // 把字符串转换成list<Long>
                List<Long> tagIdList = changeStringToLongList(blog.getTagsId(), FILE_SEGMENTATION);
                tagList = tagService.listByIds(tagIdList);
            }
            blog.setUser(blogUser);
            blog.setType(blogType);
            blog.setTagList(tagList);
        });
        return blogList;
    }

    @Override
    public void saveTags(Blog blog) {
        if (!StringUtils.isEmpty(blog.getTagsId())) {
            List<Long> tagIdList = changeStringToLongList(blog.getTagsId(), FILE_SEGMENTATION);
            tagIdList.stream().forEach(tagId -> {
                BlogTag blogTag = new BlogTag();
                blogTag.setTagId(tagId);
                blogTag.setBlogId(blog.getId());
                blogTag.setCreateTime(new Date());
                blogTagService.save(blogTag);
            });
        }
    }

    @Override
    public void updateBlogTag(Blog blog) {
        if (!StringUtils.isEmpty(blog.getTagsId())) {
            List<Long> tagIdList = changeStringToLongList(blog.getTagsId(), FILE_SEGMENTATION);
            tagIdList.stream().forEach(tagId -> {
                BlogTag blogTag = new BlogTag();
                blogTag.setTagId(tagId);
                blogTag.setBlogId(blog.getId());
                blogTag.setCreateTime(new Date());
                blogTagService.updateById(blogTag);
            });
        }
    }

    private List<Long> changeStringToLongList(String str, String code) {
        String[] split = str.split(code);
        ArrayList<Long> afterSplitList = new ArrayList<>();
        Arrays.stream(split).forEach(s -> {
            afterSplitList.add(Long.valueOf(s));
        });
        return afterSplitList;
    }
}
