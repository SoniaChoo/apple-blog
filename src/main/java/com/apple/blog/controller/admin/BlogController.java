/**
 * @author sonia
 * @description: 博客业务控制层
 * @date 2021/2/17 19:32
 */
package com.apple.blog.controller.admin;

import com.apple.blog.entity.Blog;
import com.apple.blog.entity.Tag;
import com.apple.blog.entity.Type;
import com.apple.blog.entity.User;
import com.apple.blog.service.BlogService;
import com.apple.blog.service.TagService;
import com.apple.blog.service.TypeService;
import com.apple.blog.vo.BlogQuery;
import com.apple.blog.vo.BlogTypeVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class BlogController {
  @Autowired private BlogService blogService;
  @Autowired private TypeService typeService;
  @Autowired private TagService tagService;

  @PostMapping("/blogs/search")
  public String bolgsSearch(
      @RequestParam(value = "page", defaultValue = "1") Integer pn,
      BlogQuery blogQuery,
      Model model) {
    // 先根据typeId查询中间表中的blogId，
    // 根据blogId，拼接标题和是否推荐字段，查询符合条件的博客Blog
    // 根据typeId查询类型表中的Type
    int size = 5;
    List<Blog> blogList = blogService.getBlogByBlogQuery(blogQuery);
    ArrayList<BlogTypeVO> blogTypeVOList = getBlogTypeVOList(blogList);
    Map<Integer, Object> map = getPages(pn, size, blogTypeVOList);
    model.addAttribute("page", map.get(0));
    model.addAttribute("maxPage", map.get(1));
    return "admin/blogs::blogList";
  }

  @GetMapping("/blogs")
  public String blogs(
      @RequestParam(value = "pn", defaultValue = "1") Integer pn,
      BlogQuery blogQuery,
      Model model) {
    // 先创建blogTypeVO集合
    // 先查询出所有的blogId
    // for循环上一步得到的blogIdList，找出对应的typeId，根据typeId查询type表找到type信息,创建blogTypeVO
    // 把blogTypeVo集合转换为page类型
    int size = 5;
    List<Blog> blogList = blogService.list();
    ArrayList<BlogTypeVO> blogTypeVOList = getBlogTypeVOList(blogList);
    Map<Integer, Object> map = getPages(pn, size, blogTypeVOList);
    model.addAttribute("page", map.get(0));
    model.addAttribute("maxPage", map.get(1));
    List<Type> typeList = typeService.list();
    model.addAttribute("typeList", typeList);
    List<Tag> tagList = tagService.list();
    model.addAttribute("tagList", tagList);
    return "admin/blogs";
  }

  // 跳转新增页面
  @GetMapping("/toAddBlogPage")
  public String toAddBlogPage(Model model) {
    List<Type> typeList = typeService.list();
    model.addAttribute("typeList", typeList);
    // TODO: 这里还要查询到所有标签
    List<Tag> tagList = tagService.list();
    model.addAttribute("tagList", tagList);
    // 在model中放一个空的BlogTypeVO是为了能够在修改页面时传一些初始化的值
    model.addAttribute("blog", new BlogTypeVO());
    return "admin/blogs-input";
  }

  // 新增保存
  @PostMapping("/saveOrUpdateBlog")
  public String saveBlog(Blog blog, RedirectAttributes attributes, HttpSession session) {
    blog.setCreateTime(new Date());
    blog.setUpdateTime(new Date());
    blog.setViews(0);
    User loginUser = (User) session.getAttribute("loginUser");
    blog.setUserId(loginUser.getId());
    // TODO： 对tagsId的赋值加一下，试着不要把tagsId写在数据库看看
    boolean b = blogService.save(blog);
    if (b) {
      attributes.addFlashAttribute("msg", "新增成功");
    } else {
      attributes.addFlashAttribute("msg", "新增失败");
    }
    return "redirect:/admin/blogs";
  }

  // 跳转修改页面
  @GetMapping("/{id}/toEditBlogPage")
  public String toEditBlogPage(@PathVariable("id") Long id, Model model) {
    Blog blog = blogService.getById(id);
    BlogTypeVO blogTypeVO = getBlogTypeVOList(Collections.singletonList(blog)).get(0);
    model.addAttribute("blog", blogTypeVO);
    model.addAttribute("typeList", typeService.list());
    // TODO 把标签的功能加上
    model.addAttribute("tagList", tagService.list());
    return "admin/blogs-edit";
  }

  // 修改保存
  @PutMapping("/saveOrUpdateBlog")
  public String updateBlog(Blog blog, RedirectAttributes redirectAttributes) {
    blogService.updateById(blog);
    redirectAttributes.addFlashAttribute("msg", "操作成功");
    return "redirect:/admin/blogs";
  }

  private ArrayList<BlogTypeVO> getBlogTypeVOList(List<Blog> blogList) {
    ArrayList<BlogTypeVO> blogTypeVOS = new ArrayList<>();
    for (Blog blog : blogList) {
      Type type = typeService.getById(blog.getTypeId());

      BlogTypeVO blogTypeVO = new BlogTypeVO();
      blogTypeVO.setTitle(blog.getTitle());
      blogTypeVO.setUpdateTime(blog.getUpdateTime());
      blogTypeVO.setTypeName(type.getName());
      blogTypeVO.setId(blog.getId());
      blogTypeVO.setPublished(blog.getPublished());
      blogTypeVO.setFlag(blog.getFlag());
      blogTypeVO.setContent(blog.getContent());
      blogTypeVO.setTypeId(blog.getTypeId());
      blogTypeVO.setTagsId(blog.getTagsId());
      blogTypeVO.setFirstPicture(blog.getFirstPicture());
      blogTypeVO.setRecommend(blog.getRecommend());
      blogTypeVO.setAppreciation(blog.getAppreciation());
      blogTypeVO.setCommentabled(blog.getCommentabled());
      blogTypeVO.setShareStatement(blog.getShareStatement());
      blogTypeVOS.add(blogTypeVO);
    }
    return blogTypeVOS;
  }

  /**
   * 分页函数
   *
   * @param currentPage 当前页数
   * @param pageSize 每一页的数据条数
   * @param list 要进行分页的数据列表
   * @return 当前页要展示的数据
   */
  private Map<Integer, Object> getPages(Integer currentPage, Integer pageSize, List list) {
    Page page = new Page();
    int size = list.size();

    if (pageSize > size) {
      pageSize = size;
    }

    // 求出最大页数，防止currentPage越界
    int maxPage = size % pageSize == 0 ? size / pageSize : size / pageSize + 1;

    if (currentPage > maxPage) {
      currentPage = maxPage;
    }

    // 当前页第一条数据的下标
    int curIdx = currentPage > 1 ? (currentPage - 1) * pageSize : 0;

    List pageList = new ArrayList();

    // 将当前页的数据放进pageList
    for (int i = 0; i < pageSize && curIdx + i < size; i++) {
      pageList.add(list.get(curIdx + i));
    }

    page.setCurrent(currentPage).setSize(pageSize).setTotal(list.size()).setRecords(pageList);
    HashMap<Integer, Object> map = new HashMap<>();
    map.put(0, page);
    map.put(1, maxPage);
    return map;
  }
}
