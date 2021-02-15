/**
 * @author sonia
 * @description: 分类实体
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
@TableName("t_type")
public class Type {
    private Long oid;
    private String name;
    private String uid;
    private Date createTime;
    private Date updateTime;
}
