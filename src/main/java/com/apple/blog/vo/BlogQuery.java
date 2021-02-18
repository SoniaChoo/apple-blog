/**
 * @author sonia
 * @description: 博客查询vo
 * @date 2021/2/17 19:41
 */
package com.apple.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogQuery {
    private String title;
    private Long typeId;
    private Boolean recommend;

}
