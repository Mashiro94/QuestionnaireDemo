package com.example.demo.dao;

import com.example.demo.entity.Questionnaire;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Questionnaire)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-02 09:02:50
 */
@Mapper
public interface QuestionnaireDao {

    /**
     * 通过ID查询单条数据
     *
     * @param questionnaireId 主键
     * @return 实例对象
     */
    Questionnaire queryById(Integer questionnaireId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Questionnaire> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param questionnaire 实例对象
     * @return 对象列表
     */
    List<Questionnaire> queryAll(Questionnaire questionnaire);

    /**
     * 新增数据
     *
     * @param questionnaire 实例对象
     * @return 影响行数
     */
    int insert(Questionnaire questionnaire);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Questionnaire> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Questionnaire> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Questionnaire> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Questionnaire> entities);

    /**
     * 修改数据
     *
     * @param questionnaire 实例对象
     * @return 影响行数
     */
    int update(Questionnaire questionnaire);

    /**
     * 通过主键删除数据
     *
     * @param questionnaireId 主键
     * @return 影响行数
     */
    int deleteById(Integer questionnaireId);
}