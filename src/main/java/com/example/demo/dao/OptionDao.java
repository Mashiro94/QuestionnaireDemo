package com.example.demo.dao;

import com.example.demo.entity.Option;
import com.example.demo.entity.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Option)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-02 09:02:49
 */
public interface OptionDao {

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
     * @return 影响行数
     */
    int insert(Option option);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Option> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Option> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Option> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Option> entities);

    /**
     * 修改数据
     *
     * @param option 实例对象
     * @return 影响行数
     */
    int update(Option option);

    /**
     * 通过主键删除数据
     *
     * @param optionId 主键
     * @return 影响行数
     */
    int deleteById(Integer optionId);

}