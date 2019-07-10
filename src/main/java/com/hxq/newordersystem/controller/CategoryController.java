/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CategoryController
 * Author:   hxq
 * Date:     2019/7/8 16:22
 * Description: 菜品分类的控制类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxq.newordersystem.controller;

import com.hxq.newordersystem.entity.Category;
import com.hxq.newordersystem.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 〈一句话功能简述〉<br> 
 * 〈菜品分类的控制类〉
 *
 * @author hxq
 * @create 2019/7/8
 * @since 1.0.0
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Web端
     * 找到所有的菜品分类
     * 前端href为/findallcategory。请求方式是Get
     * 得到的所有菜品分类集合存入model,取名为{categorylist}
     * 返回一个显示所有分类的页面
     * 已测试接口，成功
     * @param model
     * @return
     */
   // @ResponseBody
    @GetMapping("/findallcategory")
    public String findAll(Model model){
        List<Category> categories=categoryRepository.findAll();
        //System.out.println(categories);
        model.addAttribute("categorylist",categories);
        return "显示所有分类的页面";
    }

    /**
     * 小程序端
     * 找到所有的菜品分类
     * 前端href为/findallcategory。请求方式是Get
     * 得到的所有菜品分类集合存入model,取名为{categorylist}
     * 返回一个显示所有分类的页面
     * 已测试接口，成功
     * @param model
     * @return
     */
    @ResponseBody
    @GetMapping("/wx/findallcategory")
    public List<Category> findAllWx(Model model){
        List<Category> categories=categoryRepository.findAll();
        //System.out.println(categories);
        model.addAttribute("categorylist",categories);
        return categories;
    }

    /**
     * Web端
     * 添加一个分类
     * 前端form表单提交数据，有一个属性为name，请求的方式为post
     * 返回：重定向到显示所有的分类页面
     * 已测试接口，成功
     * @param name 分类的名字
     * @return
     */
    //@ResponseBody
    @PostMapping("/addonecategory")
    public String addOne(@RequestParam("name")String name){
        Category category=new Category();
        category.setName(name);
        categoryRepository.save(category);
        //System.out.println(category.toString());
        return "redirect:/findallcategory";//重定向到显示所有分类的页面
    }

    /**
     * Web端
     * 通过分类id找到一个分类，回显到分类详情里，便于修改
     * 结果存放于model,取名为{category}
     * 返回一个显示分类详情的页面
     * 已测试接口，成功
     * @param id
     * @param model
     * @return
     */
    //@ResponseBody
    @GetMapping("/findonecategory/{id}")
    public String findOne(@PathVariable("id")Integer id,Model model){
        Optional<Category> categoryOptional=categoryRepository.findById(id);
        model.addAttribute("category",categoryOptional.get());
        //System.out.println(categoryOptional.get().toString());
        return "显示一个分类详情的页面";
    }

    /**
     * Web端
     * 修改一个分类的名字
     * 前端以form表单传递数据，请求方式为Put
     * 返回：重定向到显示所有的分类页面
     * 已测试接口，成功
     * @param id 分类的id(不可写)
     * @param name 分类的名字
     * @return
     */
    //@ResponseBody
    @PutMapping("/updateonecategory")
    public String updateOne(@RequestParam("id")Integer id,
                            @RequestParam("name")String name){
        Category category=new Category();
        category.setName(name);
        category.setId(id);
        categoryRepository.save(category);
       // System.out.println(category.toString());
        return "redirect:/findallcategory";//重定向到显示所有分类的页面

    }


}

