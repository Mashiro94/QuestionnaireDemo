package com.example.demo.controller;

import com.example.demo.entity.Question;
import com.example.demo.service.QuestionService;
import com.example.demo.entity.Option;
import com.example.demo.service.OptionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Question)表控制层
 *
 * @author makejava
 * @since 2020-11-02 09:02:50
 */
@RestController
@RequestMapping("question")
public class QuestionController {
    /**
     * 服务对象
     */
    @Resource
    private QuestionService questionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectById/{id}")
    public Question selectById(@PathVariable Integer id) {
        return this.questionService.queryById(id);
    }

    /**
     * 通过外键查询多条数据
     *
     * @param questionnaireId 外键
     * @return 单条数据
     */
    @GetMapping("selectByQuestionnaireId/{questionnaireId}")
    public List<Question> selectByQuestionnaireId(@PathVariable Integer questionnaireId) {
        return this.questionService.queryAllByQuestionnaireId(questionnaireId);
    }

    /**
     * 删除问卷
     * @param questionId 主键
     */
    @DeleteMapping("deleteById/{questionId}")
    public int deleteById(@PathVariable Integer questionId) {
        return this.questionService.deleteById(questionId);
    }

    /**
     * 添加问题
     * @param question 问题
     */
    @PostMapping("insertOne")
    @ResponseBody
    public Question insertOne(@RequestBody Question question) {
        return this.questionService.insert(question);
    }
}