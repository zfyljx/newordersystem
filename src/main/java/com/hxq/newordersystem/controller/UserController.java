/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserController
 * Author:   hxq
 * Date:     2019/7/8 16:23
 * Description: 用户的控制类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxq.newordersystem.controller;

import com.hxq.newordersystem.entity.User;
import com.hxq.newordersystem.repository.UserRepository;
import com.hxq.newordersystem.utils.HttpRequest;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户的控制类〉
 *
 * @author hxq
 * @create 2019/7/8
 * @since 1.0.0
 */
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user/findopenid")
    public Map getOpenId(@RequestParam("code")String code){

        Map map = new HashMap();
        if (code == null || code.length() == 0) {

            map.put("status", 0);

            map.put("msg", "code 不能为空");

            return map;

        }
        //小程序唯一标识   (在微信小程序管理后台获取)

        String wxspAppid = "wx62f70ec6c4379bef";

        //小程序的 app secret (在微信小程序管理后台获取)

        String wxspSecret = "90f4bdbb9289f7002bae585903d6eebe";

        //授权（必填）
        String grant_type = "authorization_code";
        //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////

        //请求参数

        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;

        //发送请求

        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);

        //解析相应内容（转换成json对象）

        JSONObject json = net.sf.json.JSONObject.fromObject(sr);

        //获取会话密钥（session_key）

        String session_key = json.get("session_key").toString();

        //用户的唯一标识（openid）

        String openid = (String) json.get("openid");
        User user=new User();
        user.setOpenId(openid);
        userRepository.save(user);
        Optional<User> user1=userRepository.findByOpenId(openid);
        if (user1.isPresent()) {
            map.put("userId", user1.get().getId());
            return map;
        }else {

            map.put("status", 1);
            map.put("msg", "找不到openid");
            return map;
        }
    }
}

