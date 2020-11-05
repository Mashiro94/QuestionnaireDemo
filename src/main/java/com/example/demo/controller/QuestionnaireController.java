package com.example.demo.controller;

import com.example.demo.entity.Questionnaire;
import com.example.demo.service.QuestionnaireService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Questionnaire)表控制层
 *
 * @author makejava
 * @since 2020-11-02 09:02:51
 */
@RestController
@RequestMapping("questionnaire")
public class QuestionnaireController {
    /**
     * 服务对象
     */
    @Resource
    private QuestionnaireService questionnaireService;

    /**
     * 查询全部问卷
     * @return 单条数据
     */
    @GetMapping("selectAll")
    public List<Questionnaire> selectAll() {
        return this.questionnaireService.queryAllByLimit(0, 999);
    }

    /**
     * 删除问卷
     * @param questionnaireId 主键
     */
    @DeleteMapping("deleteById/{questionnaireId}")
    public int deleteById(@PathVariable Integer questionnaireId) {
        return this.questionnaireService.deleteById(questionnaireId);
    }

    /**
     * 添加问卷
     * @param questionnaire 问卷
     */
    @PostMapping("insertOne")
    @ResponseBody
    public Questionnaire insertOne(@RequestBody Questionnaire questionnaire) {
        return this.questionnaireService.insert(questionnaire);
    }

}