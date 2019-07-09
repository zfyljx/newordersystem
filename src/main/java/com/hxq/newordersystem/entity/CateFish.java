/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CateFish
 * Author:   hxq
 * Date:     2019/7/9 10:05
 * Description: 分类的菜
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxq.newordersystem.entity;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈分类的菜〉
 *
 * @author hxq
 * @create 2019/7/9
 * @since 1.0.0
 */
@Entity
public class CateFish implements Serializable{

    /**
     * 分类
     */
    private Category category;

    /**
     * 分类里的菜
     */
    private List<Fish> fishList;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Fish> getFishList() {
        return fishList;
    }

    public void setFishList(List<Fish> fishList) {
        this.fishList = fishList;
    }

    @Override
    public String toString() {
        return "CateFish{" +
                "category=" + category.toString() +
                ", fishList=" + fishList.toString() +
                '}';
    }
}

