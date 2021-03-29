/**
 * @author sonia
 * @description: 博客实体
 * @date 2021/2/13 8:48
 */
package com.apple.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("t_blog")
public class Blog {
    private Long id;
    private String title;
    private String content;
    private String firstPicture;
    private String flag;
    private Integer views;
    private Boolean appreciation;
    private Boolean commentabled;
    private Boolean recommend;
    private Boolean shareStatement;
    private String description;
    private Boolean published;
    private Date createTime;
    private Date updateTime;
    private Long typeId;
    private String tagsId;
    private Long userId;
}
