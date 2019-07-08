package com.hxq.newordersystem.repository;

import com.hxq.newordersystem.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hxq on 2019/7/9.
 * 管理员的持久层接口
 */
@Repository
public interface ManagerRepository extends JpaRepository<Manager,String>{
}
