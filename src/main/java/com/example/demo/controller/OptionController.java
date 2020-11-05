package com.example.demo.controller;

import com.example.demo.entity.Option;
import com.example.demo.entity.Question;
import com.example.demo.service.OptionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Option)表控制层
 *
 * @author makejava
 * @since 2020-11-02 09:02:49
 */
@RestController
@RequestMapping("option")
public class OptionController {
    /**
     * 服务对象
     */
    @Resource
    private OptionService optionService;

    /**
     * 通过外键查询多条数据
     *
     * @param questionId 外键
     * @return 多条数据
     */
    @GetMapping("selectByQuestionId/{questionId}")
    public List<Question> selectByQuestionId(@PathVariable Integer questionId) {
        return this.optionService.queryAllByQuestionId(questionId);
    }

    /**
     * 删除选项
     * @param optionId 主键
     */
    @DeleteMapping("deleteById/{optionId}")
    public int deleteById(@PathVariable Integer optionId) {
        return this.optionService.deleteById(optionId);
    }

    /**
     * 添加选项
     * @param option 选项
     */
    @PostMapping("insertOne")
    @ResponseBody
    public Option insertOne(@RequestBody Option option) {
        return this.optionService.insert(option);
    }
}