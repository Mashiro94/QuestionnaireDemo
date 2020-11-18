package com.example.demo.controller;

import com.example.demo.entity.Option;
import com.example.demo.entity.Question;
import com.example.demo.entity.Result;
import com.example.demo.service.OptionService;
import com.example.demo.service.QuestionService;
import com.example.demo.service.ResultService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * (Result)表控制层
 *
 * @author makejava
 * @since 2020-11-02 09:15:40
 */
@RestController
@RequestMapping("result")
public class ResultController {
    /**
     * 服务对象
     */
    @Resource
    private ResultService resultService;

    @Resource
    private QuestionService questionService;

    @Resource
    private OptionService optionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Result selectOne(Integer id) {
        return this.resultService.queryById(id);
    }

    /**
     * 通过问卷号和用户号查询关联数据集
     *
     * @param questionnaireId,userId 外键
     * @return 单条数据
     */
    @GetMapping("selectByQuestionnaireUserId")
    public List<Result> selectByQuestionnaireUserId(@RequestParam(value = "questionnaireId") Integer questionnaireId, @RequestParam(value = "userId") Integer userId) {
        //写得不好，以后再改
        List<Result> results = new ArrayList<>();
        List<Question> questions = this.questionService.queryAllByQuestionnaireId(questionnaireId);

        for (Question question : questions) {
            Result result = new Result(question.getQuestionId(), userId);
            results.addAll(this.resultService.queryAll(result));
        }

        //增加了Question content
        for (Result result : results) {
            result.setResultQuestionContent(this.questionService.queryById(result.getResultQuestionId()).getQuestionContent());
        }

        //增加了Option content
        for (Result result : results) {
            String contents = result.getResultContent();
            List<String> resultOptionContents = new ArrayList<>();
            for (String content : contents.split("-")){
                if(!Objects.equals(content, "")) {
                    Option option = new Option(result.getResultQuestionId(), Integer.parseInt(content));
                    List<Option> options = this.optionService.queryAll(option); //正常情况下只能查到一个
                    resultOptionContents.add(options.get(0).getOptionContent());
                }
            }
            result.setResultOptionContent(resultOptionContents);
        }

        return results;
    }

    @PostMapping("insertOne")
    public void insertOne(@RequestBody List<Result> results) {
        //这里的result还缺少用户ID，需要下个版本增加功能
        //去重功能没有激活，是因为账号还没有填入

        Result result = new Result(results.get(0).getResultQuestionId(), 1);
        if (this.resultService.queryAll(result).size() == 0) {
            for(Result result1 : results) this.resultService.insert(result1);
        }
        else System.out.println("重复做题");
    }
}