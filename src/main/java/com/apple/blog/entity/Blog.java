/**
 * @author sonia
 * @description: 博客实体
 * @date 2021/2/13 8:48
 */
package com.apple.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Blog {
    private Long oid;
    private String title;
    private String content;
    private String firstPicture;
    private String flag;
    private Integer views;
    private Boolean appreciation;
    private Boolean commentabled;
    private Boolean recommend;
    private Boolean shareStatement;
    private Boolean published;
    private Date createTime;
    private Date updateTime;
    private String uid;
}
