/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Category
 * Author:   hxq
 * Date:     2019/7/8 16:11
 * Description: 菜品分类的实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxq.newordersystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
/**
 * 〈一句话功能简述〉<br> 
 * 〈菜品分类的实体类〉
 *
 * @author hxq
 * @create 2019/7/8
 * @since 1.0.0
 */
@Table(name = "category")
@Entity
public class Category {
    /**
     * 分类的主键，自增
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 分类的名字
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

