package com.hxq.newordersystem.repository;

import com.hxq.newordersystem.entity.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hxq on 2019/7/8.
 * 菜皮的持久层接口
 */
@Repository
public interface FishRepository extends JpaRepository<Fish,Integer> {

    /**
     * 根据分类名查找菜品
     * @param category
     * @return
     */
    public List<Fish> findAllByCategory(String category);
}
