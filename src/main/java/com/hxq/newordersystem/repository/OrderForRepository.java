package com.hxq.newordersystem.repository;

import com.hxq.newordersystem.entity.OrderFor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hxq on 2019/7/8.
 * 订单的持久层接口
 */
@Repository
public interface OrderForRepository extends JpaRepository<OrderFor,Integer> {
}
