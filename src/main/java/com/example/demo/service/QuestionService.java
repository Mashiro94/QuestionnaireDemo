package com.example.demo.service;

import com.example.demo.entity.Question;

import java.util.List;

/**
 * (Question)表服务接口
 *
 * @author makejava
 * @since 2020-11-02 09:02:50
 */
public interface QuestionService {

    /**
     * 通过ID查询单条数据
     *
     * @param questionId 主键
     * @return 实例对象
     */
    Question queryById(Integer questionId);

    /**
     * 查询多条数据
     *
     * @param questionnaireId 外键
     * @return 对象列表
     */
    List<Question> queryAllByQuestionnaireId(Integer questionnaireId);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param question 实例对象
     * @return 对象列表
     */
    List<Question> queryAll(Question question);

    /**
     * 新增数据
     *
     * @param question 实例对象
     * @return 实例对象
     */
    Question insert(Question question);

    /**
     * 修改数据
     *
     * @param question 实例对象
     * @return 实例对象
     */
    Question update(Question question);

    /**
     * 通过主键删除数据
     *
     * @param questionId 主键
     * @return 是否成功
     */
    int deleteById(Integer questionId);

}