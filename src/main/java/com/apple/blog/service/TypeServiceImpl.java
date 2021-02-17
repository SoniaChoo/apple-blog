/**
 * @author 分类业务层
 * @description: some desc
 * @date 2021/2/16 14:27
 */
package com.apple.blog.service;

import com.apple.blog.entity.Type;
import com.apple.blog.exception.NotfoundException;
import com.apple.blog.mapper.TypeMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper,Type> implements TypeService{
//    @Autowired
//    private TypeMapper typeMapper;
//
//    @Override
//    public Type getTypeById(Long id) {
//        return typeMapper.selectById(id);
//    }
//
//    @Override
//    public List<Type> getTypeByMap(Map<String, Object> map) {
//        return typeMapper.selectByMap(map);
//    }
//
//    @Override
//    public void updateType(Long id, Type type) {
//        Type t = typeMapper.selectById(id);
//        if (t == null) {
//            throw new NotfoundException("没有找到该分类");
//        }else{
//            BeanUtils.copyProperties(type,t);
//            typeMapper.updateById(t);
//        }
//    }
//
//    @Override
//    public void addType(Type type) {
//        typeMapper.insert(type);
//    }
//
//    @Override
//    public void deleteType(Long id) {
//        typeMapper.deleteById(id);
//    }
}
