package com.hxq.newordersystem.repository;

import com.hxq.newordersystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hxq on 2019/7/8.
 * 菜品分类的持久层接口
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{
}
