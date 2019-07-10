/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Fish
 * Author:   hxq
 * Date:     2019/7/8 16:04
 * Description: 菜品的实体类
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
 * 〈菜品的实体类〉
 *
 * @author hxq
 * @create 2019/7/8
 * @since 1.0.0
 */
@Entity
@Table(name = "fish")
public class Fish {
    /**
     * 菜品主键，自增
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 菜名
     */
    private String name;

    /**
     * 菜图片的存放路径
     */
    private String picturePath;

    /**
     * 菜的简介
     */
    private String description;

    /**
     * 菜的单价
     */
    private  Float price;

    /**
     * 菜所属的分类的
     */
    private String category;

    private Integer count;

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

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picturePath='" + picturePath + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

