/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Manager
 * Author:   hxq
 * Date:     2019/7/9 0:13
 * Description: 管理员的实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxq.newordersystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 〈一句话功能简述〉<br> 
 * 〈管理员的实体类〉
 *
 * @author hxq
 * @create 2019/7/9
 * @since 1.0.0
 */
@Entity
@Table(name = "manager")
public class Manager {
    @Id
    private String id;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

