/**
 * @author sonia
 * @description: 博客用户中间表
 * @date 2021/2/13 12:37
 */
package com.apple.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogUser {
    private Long oid;
    private Long blogId;
    private Long userId;
    private String uid;
    private Date createTime;
    private Date updateTime;
}
