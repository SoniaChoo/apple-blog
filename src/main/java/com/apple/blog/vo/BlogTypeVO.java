/**
 * @author zhushjr
 * @description: some desc
 * @date 2021/2/18 12:23
 */
package com.apple.blog.vo;

import com.apple.blog.entity.Blog;
import com.apple.blog.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogTypeVO {
    private Long id;
    private String title;
    private Boolean recommend;
    private Date updateTime;
    private String typeName;
    private Boolean published;
    private String flag;
    private String content;
    private Long typeId;
    private String tagsId;
    private String firstPicture;
    private Boolean appreciation;
    private Boolean commentabled;
    private Boolean shareStatement;
}
