package com.hxq.newordersystem.repository;

import com.hxq.newordersystem.entity.Waiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hxq on 2019/7/9.
 * 服务员的持久层接口
 */
@Repository
public interface WaiterRepository extends JpaRepository<Waiter,String>{
}
