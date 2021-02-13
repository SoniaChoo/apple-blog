/**
 * @author sonia
 * @description: 标签实体
 * @date 2021/2/13 8:51
 */
package com.apple.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tag {
    private Long oid;
    private String name;
    private String uid;
}
