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
    private Long blogId;
    private String blogTitle;
    private Boolean blogRecommend;
    private Date blogUpdateTime;
    private String typeName;
}
