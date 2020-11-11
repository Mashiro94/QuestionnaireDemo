package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import net.sf.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-11-02 09:02:53
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    @GetMapping("insertOne")
    public User insertOne(@RequestParam(value="code") String code) {

        String appId = "wx5746bcc018bdbeac";

        String secret = "eb1ab4ffd20ff08eecbda49c995bd732";

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId +
                "&secret=" + secret +
                "&js_code=" + code +
                "&grant_type=authorization_code";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        String userString = responseEntity.getBody();

        JSONObject jsonObject = JSONObject.fromObject(userString);
        User user = new User(jsonObject.getString("session_key"), jsonObject.getString("openid"));

        if(this.userService.queryAll(user).isEmpty()) {
            System.out.println("youle");
            return null;
        }


        return this.userService.insert(user);
    }
}