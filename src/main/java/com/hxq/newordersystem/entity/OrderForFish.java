/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: OrderForFish
 * Author:   hxq
 * Date:     2019/7/8 16:10
 * Description: 一张完整的订单实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxq.newordersystem.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈一张完整的订单实体类〉
 *
 * @author hxq
 * @create 2019/7/8
 * @since 1.0.0
 */
public class OrderForFish implements Serializable {
    /**
     * 订单详情
     */
    private OrderFor orderFor;

    /**
     * 订单里的菜
     */
    private List<OrderFish> orderFishs;

    public OrderFor getOrderFor() {
        return orderFor;
    }

    public void setOrderFor(OrderFor orderFor) {
        this.orderFor = orderFor;
    }

    public List<OrderFish> getOrderFishs() {
        return orderFishs;
    }

    public void setOrderFishs(List<OrderFish> orderFishs) {
        this.orderFishs = orderFishs;
    }

    @Override
    public String toString() {
        return "OrderForFish{" +
                "orderFor=" + orderFor.toString() +
                ", orderFishs=" + orderFishs.toString() +
                '}';
    }
}

