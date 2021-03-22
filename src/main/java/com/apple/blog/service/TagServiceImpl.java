/**
 * @author sonia
 * @description: tag业务层
 * @date 2021/2/19 16:25
 */
package com.apple.blog.service;

import com.apple.blog.entity.Tag;
import com.apple.blog.mapper.TagMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl extends ServiceImpl<TagMapper,Tag> implements TagService {
}
