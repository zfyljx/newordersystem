/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: OrderFish
 * Author:   hxq
 * Date:     2019/7/8 16:08
 * Description: 订单里的菜实体类
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
 * 〈订单里的菜实体类〉
 *
 * @author hxq
 * @create 2019/7/8
 * @since 1.0.0
 */
@Entity
@Table(name = "orderfish")
public class OrderFish {

    /**
     * 订单的点的菜
     * id,主键，自增
     */
    @GeneratedValue
    @Id
    private Integer id;

    /**
     * 订单的id
     */
    private Integer orderId;

    /**
     * 菜的id
     */
    private Integer fishId;

    /**
     * 菜名
     */
    private String fishName;

    /**
     * 菜的价格
     */
    private Float price;

    /**
     * 菜的数量
     */
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getFishId() {
        return fishId;
    }

    public void setFishId(Integer fishId) {
        this.fishId = fishId;
    }

    public String getFishName() {
        return fishName;
    }

    public void setFishName(String fishName) {
        this.fishName = fishName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "OrderFish{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", fishId=" + fishId +
                ", fishName='" + fishName + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}

