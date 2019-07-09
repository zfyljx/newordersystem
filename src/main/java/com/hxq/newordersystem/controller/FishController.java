/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: FishController
 * Author:   hxq
 * Date:     2019/7/8 16:20
 * Description: 菜品的控制类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxq.newordersystem.controller;

import com.hxq.newordersystem.entity.CateFish;
import com.hxq.newordersystem.entity.Category;
import com.hxq.newordersystem.entity.Fish;
import com.hxq.newordersystem.repository.CategoryRepository;
import com.hxq.newordersystem.repository.FishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 〈一句话功能简述〉<br> 
 * 〈菜品的控制类〉
 *
 * @author hxq
 * @create 2019/7/8
 * @since 1.0.0
 */
@Controller
public class FishController {

    @Autowired
    private FishRepository fishRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Web端
     * 用于查找所有的菜品
     * 浏览器输入方法的映射/findallfish，拿到所有的菜品list存放到Model中取名为{fishlist}，返回到页面显示
     * 已测试接口，成功
     * @param model
     * @return
     */
   // @ResponseBody
//    @GetMapping("/findallfish")
//    public String findAll(Model model){
//        List<Fish> fishs=fishRepository.findAll();
//        model.addAttribute("fishlist",fishs);
//        return "查询所有菜品的页面";
//       // System.out.println(fishs);
//        //return fishs.toString();
//    }
    @GetMapping("/findallfish")
    public String findAll(Model model){
        ArrayList<CateFish> cateFishList=new ArrayList<CateFish>();
        List<Category> categoryList=categoryRepository.findAll();
        for (Category category:categoryList){
            //存分类
            CateFish cateFish=new CateFish();
            cateFish.setCategory(category);
            //找分类的菜
            List<Fish> fishs=fishRepository.findAllByCategory(category.getName());
            //存分类的菜
            cateFish.setFishList(fishs);
            cateFishList.add(cateFish);
        }
        model.addAttribute("catefishlist",cateFishList);
        return "查询所有菜品的页面";
        // System.out.println(fishs);
        //return fishs.toString();
    }

    /**
     * 用于小程序中的
     * 请求所有菜品，
     * 请求方式是GET,请求路径是url+/fish/findall,返回类型是是list，Json格式
     * 已测试，成功
     * @return
     */
    @ResponseBody
    @GetMapping("/fish/findall")
    public List<Fish> findAllFish(){
        return fishRepository.findAll();
    }


    /**
     * Web端
     * 根据菜品id删除一个菜品
     * 前端请求href为/deleteonefish/{id},请求方式GET,需要传一个菜品的id,删除完成后重定向到返回找所有菜品的函数
     * 已测试接口，成功
     * @param id
     * @return
     */
   // @ResponseBody
    @GetMapping("/deleteonefish/{id}")
    public String updateOne(@PathVariable("id")Integer  id){
        fishRepository.deleteById(id);
        return "redirect:/findallfish";//重定向到找所有菜品的函数
    }

    /**
     * Web端
     * 根据菜品id找到一个菜品
     * 用于修改菜品，根据菜品的id找到菜品的所有信息，然后回显到修改界面中
     * 前端请求href为/findonefish/{id},需要向后台传入一个菜品id
     * 查询结果存放进Model,取名为{fish}
     * 已测试接口，成功
     * @param id
     * @param model
     * @return
     */
   // @ResponseBody
    @GetMapping("/findonefish/{id}")
    public String findOneFish(@PathVariable("id")Integer id, Model model){
        Optional<Fish> fish=fishRepository.findById(id);
        model.addAttribute("fish",fish.get());
        //System.out.println(fish.get().toString());
        return "一个修改菜品的页面";
    }

    /**
     * Web端
     * 更新修改一个菜品
     * 前端请求方式为PUT,(也可将其改为POST,则底下的PutMapping换成PostMapping),Form请求的action为/updateonefish
     * 返回到所有菜品的页面
     * 已测试接口，成功
     * @param id
     * @param name
     * @param picturePath
     * @param description
     * @param price
     * @param category
     * @return
     */
    //@ResponseBody
    @PutMapping("/updateonefish")
    public String updateOne(@RequestParam("id")Integer id,
                            @RequestParam("name")String name,
                            @RequestParam("picturePath")String picturePath,
                            @RequestParam("description")String description,
                            @RequestParam("price")Float price,
                            @RequestParam("category")String category){
        Fish fish=new Fish();
        fish.setCategory(category);
        fish.setDescription(description);
        fish.setId(id);
        fish.setName(name);
        fish.setPicturePath(picturePath);
        fish.setPrice(price);
        fishRepository.save(fish);
        return "redirect:/findallfish";//重定向到找所有菜品的函数
    }


    /**
     * 还差一个菜品的添加，需要上传菜品的图片
     */


    /**
     * 测试添加一个菜品，还未有上传功能
     * 成功
     * @param name
     * @param picturePath
     * @param description
     * @param price
     * @param category
     * @return
     */
    @ResponseBody
    @PostMapping("/fish/test/addone")
    public Fish addOne(   @RequestParam("name")String name,
                            @RequestParam("picturePath")String picturePath,
                            @RequestParam("description")String description,
                            @RequestParam("price")Float price,
                            @RequestParam("category")String category){
        Fish fish=new Fish();
        fish.setCategory(category);
        fish.setDescription(description);
        fish.setName(name);
        fish.setPicturePath(picturePath);
        fish.setPrice(price);
       return fishRepository.save(fish);

    }
}

