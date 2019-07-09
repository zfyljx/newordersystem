/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UploadController
 * Author:   hxq
 * Date:     2019/7/9 17:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxq.newordersystem.controller;

import com.hxq.newordersystem.entity.Fish;
import com.hxq.newordersystem.repository.FishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hxq
 * @create 2019/7/9
 * @since 1.0.0
 */
@Controller
public class UploadController {

    @Autowired
    private FishRepository fishRepository;


    /**
     * Web端
     * 点击添加菜品按钮，跳转到添加界面，里面有上传一个菜的图片，菜名，菜分类，菜简介，菜价格
     * 返回重定向到一个添加的页面
     * @return
     */
    @GetMapping("/showaddpage")
    public String showAddPage(){
        return "redirect:/菜品添加界面";
    }
    /**
     * Web端，
     * 添加一个菜品，包括上传菜的名字
     * 前端为form表单请求，需要提交一下五个信息，action为/fileUpload
     * 上传菜品存入数据库
     * 已测试接口，成功
     * @param file
     * @param name
     * @param price
     * @param category
     * @param description
     * @param model
     * @param request
     * @return
     */
   // @ResponseBody
    @PostMapping(value = "/fileUpload")
    public String fileUpload(@RequestParam(value = "file") MultipartFile file,
                             @RequestParam(value = "name")String name,
                             @RequestParam(value = "price")Float price,
                             @RequestParam(value = "category")String category,
                             @RequestParam(value = "description")String description,
                             Model model, HttpServletRequest request) {
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "D://temp-rainy//"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/temp-rainy/" + fileName;

        Fish fish=new Fish();
        fish.setPrice(price);
        fish.setPicturePath(filename);
        fish.setName(name);
        fish.setDescription(description);
        fish.setCategory(category);
        fishRepository.save(fish);
        System.out.println(fish);
//        model.addAttribute("filename", filename);
//        System.out.println(filename);
        return "redirect:/findallfish";//重定向到显示所有菜品的页面
    }
}

