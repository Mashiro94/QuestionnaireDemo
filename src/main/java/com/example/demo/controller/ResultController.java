package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.service.ResultService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

}