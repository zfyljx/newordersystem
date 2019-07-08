/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: User
 * Author:   hxq
 * Date:     2019/7/8 16:13
 * Description: 用户的实体类
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
 * 〈用户的实体类〉
 *
 * @author hxq
 * @create 2019/7/8
 * @since 1.0.0
 */
@Entity
@Table(name = "user")
public class User {
    /**
     * 用户的id,自增
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 每个用户的openid
     */
    private String openId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", openId='" + openId + '\'' +
                '}';
    }
}

