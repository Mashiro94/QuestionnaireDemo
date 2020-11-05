package com.example.demo.service;

import com.example.demo.entity.Questionnaire;

import java.util.List;

/**
 * (Questionnaire)表服务接口
 *
 * @author makejava
 * @since 2020-11-02 09:02:50
 */
public interface QuestionnaireService {

    /**
     * 通过ID查询单条数据
     *
     * @param questionnaireId 主键
     * @return 实例对象
     */
    Questionnaire queryById(Integer questionnaireId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Questionnaire> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param questionnaire 实例对象
     * @return 实例对象
     */
    Questionnaire insert(Questionnaire questionnaire);

    /**
     * 修改数据
     *
     * @param questionnaire 实例对象
     * @return 实例对象
     */
    Questionnaire update(Questionnaire questionnaire);

    /**
     * 通过主键删除数据
     *
     * @param questionnaireId 主键
     * @return 是否成功
     */
    int deleteById(Integer questionnaireId);

}