/**
 * @author sonia
 * @description: 博客分类中间表
 * @date 2021/2/13 12:34
 */
package com.apple.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogType {
    private Long oid;
    private Long blogId;
    private Long typeId;
    private String uid;
}
