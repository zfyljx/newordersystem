package com.hxq.newordersystem.repository;

import com.hxq.newordersystem.entity.OrderFish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hxq on 2019/7/8.
 * 订单里的菜的持久层接口
 */
@Repository
public interface OrderFishRepository extends JpaRepository<OrderFish,Integer>{

    /**
     * 根据订单id找到所有属于一张订单上的菜
     * @param orderId
     * @return
     */
    public List<OrderFish> findAllByOrderId(Integer orderId);
}
