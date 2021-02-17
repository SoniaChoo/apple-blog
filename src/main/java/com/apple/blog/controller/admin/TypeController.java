/**
 * @author sonia
 * @description: some desc
 * @date 2021/2/16 14:38
 */
package com.apple.blog.controller.admin;

import com.apple.blog.entity.Type;
import com.apple.blog.exception.SameNameException;
import com.apple.blog.service.TypeService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String types(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        // 构造分页参数
        Page<Type> page = new Page<>(pn,5);
        // 调用page进行分页
        Page<Type> typePage = typeService.page(page, null);
//    System.out.println(typePage);
        model.addAttribute("page",typePage);
        return "admin/types";
    }


    // 跳转新增分类页面
    @GetMapping("/toAddPage")
    public String toAddPage(){
        return "admin/types-input";
    }

    // 跳转修改分类页面，查出当前分类，在页面回显
    @GetMapping("/{id}/toEditPage")
    public String toEditPage(@PathVariable("id") Long id, Model model){
        model.addAttribute("type",typeService.getById(id));
        // "admin/types-input" 是一个修改添加二合一的页面
        return "admin/types-input";
    }

    // 新增分类
    @PostMapping("/saveOrUpdateType")
    @Transactional
    public String saveType(Type type, RedirectAttributes redirectAttributes){
        type.setUid(UUID.randomUUID().toString());
        if (checkTypes(type)) {
            typeService.save(type);
            redirectAttributes.addFlashAttribute("msg","操作成功");
            return "redirect:/admin/types"; //不能直接跳转到types页面，否则不会显示type数据(没经过types方法)
        };
//        throw new SameNameException("不能添加重复的分类");
        redirectAttributes.addFlashAttribute("msg","不能添加重复的分类");
        return "redirect:/admin/toAddPage";
    }
    //修改分类
    @PutMapping("/saveOrUpdateType")
    @Transactional
    public String updateType(Type type, RedirectAttributes redirectAttributes){
        if (checkTypes(type)) {
            typeService.updateById(type);
            redirectAttributes.addFlashAttribute("msg","操作成功");
            return "redirect:/admin/types";
        }
        redirectAttributes.addFlashAttribute("type",type);
        redirectAttributes.addFlashAttribute("msg","不能添加重复的分类");
        return "redirect:/admin/toAddPage";
    }

    @GetMapping("/deleteType")
    @Transactional
    public String deleteType(Long id) {
        // TODO: 被引用的分类不能删除
        typeService.removeById(id);
        return "redirect:/admin/types";
    }

    public boolean checkTypes(Type type) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name",type.getName());
        List<Type> types = typeService.listByMap(map);
        if (types.size() > 0) {
            return false;
        }
        return true;
    }
}
