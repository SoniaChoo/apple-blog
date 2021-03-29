/**
 * @author 分类业务层
 * @description: some desc
 * @date 2021/2/16 14:27
 */
package com.apple.blog.service;

import com.apple.blog.entity.Type;
import com.apple.blog.mapper.TypeMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {
}
