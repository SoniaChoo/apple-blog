/**
 * @author sonia
 * @description: 标签实体
 * @date 2021/2/13 8:51
 */
package com.apple.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("t_tag")
public class Tag {
    private Long id;
    private String name;
    private Date createTime;
    private Date updateTime;
}
