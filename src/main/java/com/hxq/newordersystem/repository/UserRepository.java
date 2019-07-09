package com.hxq.newordersystem.repository;

import com.hxq.newordersystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by hxq on 2019/7/8.
 * 用户的持久层接口
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    /**
     * 通过openid找到一个user对象
     * @param openid
     * @return
     */
    public Optional<User> findByOpenId(String openid);
}
