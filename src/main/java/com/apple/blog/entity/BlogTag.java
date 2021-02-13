/**
 * @author sonia
 * @description: 博客标签中间表
 * @date 2021/2/13 12:33
 */
package com.apple.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogTag {
    private Long oid;
    private Long blogId;
    private Long tagId;
    private String uid;
}
