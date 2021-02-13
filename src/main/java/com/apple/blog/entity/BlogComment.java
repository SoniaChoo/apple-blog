/**
 * @author sonia
 * @description: 博客评论中间表
 * @date 2021/2/13 12:36
 */
package com.apple.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogComment {
    private Long oid;
    private Long blogId;
    private Long commentId;
    private String uid;
}
