package com.example.demo.dao;

import com.example.demo.entity.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Question)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-02 09:02:50
 */
public interface QuestionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param questionId 主键
     * @return 实例对象
     */
    Question queryById(Integer questionId);

    /**
     * 查询指定行数据
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
     * @return 影响行数
     */
    int insert(Question question);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Question> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Question> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Question> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Question> entities);

    /**
     * 修改数据
     *
     * @param question 实例对象
     * @return 影响行数
     */
    int update(Question question);

    /**
     * 通过主键删除数据
     *
     * @param questionId 主键
     * @return 影响行数
     */
    int deleteById(Integer questionId);

}