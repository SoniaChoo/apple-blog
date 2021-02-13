/**
 * @author sonia
 * @description: 评论实体
 * @date 2021/2/13 8:52
 */
package com.apple.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
    private Long oid;
    private String nickname;
    private String comment;
    private String avatar;
    private String email;
    private Date createTime;
    private String uid;
}
