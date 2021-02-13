/**
 * @author sonia
 * @description: 用户实体
 * @date 2021/2/13 8:51
 */
package com.apple.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Long oid;
    private String nickname;
    private String userName;
    private String password;
    private String email;
    private String avatar;
    private Integer type;
    private Date createTime;
    private Date updateTime;
    private String uid;
}
