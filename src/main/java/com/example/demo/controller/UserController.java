package com.example.demo.controller;

import com.example.demo.entity.Question;
import com.example.demo.entity.Result;
import com.example.demo.entity.User;
import com.example.demo.service.QuestionService;
import com.example.demo.service.ResultService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import net.sf.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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

    @Resource
    private QuestionService questionService;

    @Resource
    private ResultService resultService;

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

    //微信小程序登录例，可能在下个版本中会重写
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
            System.out.println("该用户已存在");
            return null;
        }

        return this.userService.insert(user);
    }

    @GetMapping("selectByQuestionnaireId/{questionnaireId}")
    public List<User> selectByQuestionnaireId(@PathVariable Integer questionnaireId) {
        List<Question> questions = this.questionService.queryAllByQuestionnaireId(questionnaireId); //获取问卷里的所有问题
        HashSet<Integer> userIds = new HashSet<>(); //声明一个不可重复的HashSet
        for (Question question : questions) {   //对于每一个问题
            List<Result> results = this.resultService.queryAll(new Result(question.getQuestionId())); //先用类型查找查出这个问题的所有解答
            for (Result result1 : results) {
                userIds.add(result1.getResultUserId()); //将解答的用户加入用户名单
            }
        }
        return this.userService.queryAllByIds(new ArrayList<>(userIds));  //返回所有解答过的用户，即做过这份问卷的用户
    }
}