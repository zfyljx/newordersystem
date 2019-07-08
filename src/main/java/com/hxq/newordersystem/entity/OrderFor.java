/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: OrderFor
 * Author:   hxq
 * Date:     2019/7/8 16:06
 * Description: 订单是实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxq.newordersystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
/**
 * 〈一句话功能简述〉<br> 
 * 〈订单是实体类〉
 *
 * @author hxq
 * @create 2019/7/8
 * @since 1.0.0
 */
@Table(name = "orderfor")
@Entity
public class OrderFor {
    /**
     * 订单id,主键，自增
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 用户的id
     */
    private Integer userId;

    /**
     * 桌号
     */
    private Integer tableNumber;

    /**
     * 人数
     */
    private Integer number;

    /**
     * 订单总价
     */
    private Float sum;

    /**
     * 打折后的总价，此属性不非空，则这个属性作为订单总价
     */
    private Float newSum;

    /**
     * 下单时间
     */
    private Date orderTime;

    /**
     * 订单的支付状态：分为已支付和未支付
     */
    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum;
    }

    public Float getNewSum() {
        return newSum;
    }

    public void setNewSum(Float newSum) {
        this.newSum = newSum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "OrderFor{" +
                "id=" + id +
                ", userId=" + userId +
                ", tableNumber=" + tableNumber +
                ", number=" + number +
                ", sum=" + sum +
                ", newSum=" + newSum +
                ", orderTime=" + orderTime +
                ", state='" + state + '\'' +
                '}';
    }
}

