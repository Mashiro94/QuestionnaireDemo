package com.example.demo.service;

import com.example.demo.entity.Option;

import java.util.List;

/**
 * (Option)表服务接口
 *
 * @author makejava
 * @since 2020-11-02 09:02:49
 */
public interface OptionService {

    /**
     * 通过ID查询单条数据
     *
     * @param optionId 主键
     * @return 实例对象
     */
    Option queryById(Integer optionId);

    /**
     * 查询多条数据
     *
     * @param questionId 外键
     * @return 对象列表
     */
    List<Option> queryAllByQuestionId(Integer questionId);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param option 实例对象
     * @return 对象列表
     */
    List<Option> queryAll(Option option);

    /**
     * 新增数据
     *
     * @param option 实例对象
     * @return 实例对象
     */
    Option insert(Option option);

    /**
     * 修改数据
     *
     * @param option 实例对象
     * @return 实例对象
     */
    Option update(Option option);

    /**
     * 通过主键删除数据
     *
     * @param optionId 主键
     * @return 是否成功
     */
    int deleteById(Integer optionId);

}