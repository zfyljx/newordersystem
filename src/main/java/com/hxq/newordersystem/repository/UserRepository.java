package com.hxq.newordersystem.repository;

import com.hxq.newordersystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hxq on 2019/7/8.
 * 用户的持久层接口
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
