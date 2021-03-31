/**
 * @author sonia
 * @description: some desc
 * @date 2021/2/17 19:23
 */
package com.apple.blog.service;

import com.apple.blog.entity.Blog;
import com.apple.blog.vo.BlogQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface BlogService extends IService<Blog> {
    List<Blog> getBlogByBlogQuery(BlogQuery blogQuery);

    List<Map<String, Object>> getBlogCountByType(Integer limit);

    List<Map<String, Object>> getBlogCountByTag(Integer limit);

    List<Blog> getBlogByRecommend(Integer limit);

    List<Blog> getBlogListByTop(Integer limit);

    Page<Blog> getBlogByPage(Page page);

    List<Blog> setUserByBlogList(List<Blog> blogList);

    void saveTags(Blog blog);
}
