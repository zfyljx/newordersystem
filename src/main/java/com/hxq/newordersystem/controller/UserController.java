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
import com.hxq.newordersystem.utils.AesCbcUtil;
import com.hxq.newordersystem.utils.HttpRequest;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
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

    /**
     * decoding encrypted data to get openid
     *
     * @param iv
     * @param encryptedData
     * @param code
     * @return
     */
    @PostMapping(value = "/decodeUserInfo")
    private Map decodeUserInfo(@RequestParam("iv") String iv,
                               @RequestParam("encryptedData")String encryptedData,
                               @RequestParam("code") String code) {
        Map map = new HashMap();
        // login code can not be null
        if (code == null || code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            return map;
        }
        // mini-Program's AppID
        String wechatAppId = "wx62f70ec6c4379bef";

        // mini-Program's session-key
        String wechatSecretKey = "90f4bdbb9289f7002bae585903d6eebe";

        String grantType = "authorization_code";

        // using login code to get sessionId and openId
        String params = "appid=" + wechatAppId + "&secret=" + wechatSecretKey + "&js_code=" + code + "&grant_type=" + grantType;

        // sending request
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);

        // analysis request content
        JSONObject json = JSONObject.fromObject(sr);

        // getting session_key
        String sessionKey = json.get("session_key").toString();

        // getting open_id
        String openId = json.get("openid").toString();

        // decoding encrypted info with AES
        try {
            String result = AesCbcUtil.decrypt(encryptedData, sessionKey, iv, "UTF-8");
            if (null != result && result.length() > 0) {
                map.put("status", 1);
                map.put("msg", "解密成功");
                JSONObject userInfoJSON = JSONObject.fromObject(result);

                //存数据
                User user=new User();
                user.setOpenId(userInfoJSON.get("openId").toString());
                List<User> userList=userRepository.findAll();
                Optional<User> userOptional=userRepository.findByOpenId(userInfoJSON.get("openId").toString());
                if (!userOptional.isPresent()) {
                    userRepository.save(user);
                }
                Optional<User> userOptional1=userRepository.findByOpenId(userInfoJSON.get("openId").toString());
                Map userInfo = new HashMap();
                userInfo.put("userId",userOptional1.get().getId());
                userInfo.put("openId", userInfoJSON.get("openId"));
                userInfo.put("nickName", userInfoJSON.get("nickName"));
                userInfo.put("gender", userInfoJSON.get("gender"));
                userInfo.put("city", userInfoJSON.get("city"));
                userInfo.put("province", userInfoJSON.get("province"));
                userInfo.put("country", userInfoJSON.get("country"));
                userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
                userInfo.put("unionId", userInfoJSON.get("unionId"));
                map.put("userInfo", userInfo);
                return map;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("status", 0);
        map.put("msg", "解密失败");
        return map;
    }
}

