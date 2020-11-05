package com.example.demo.dao;

import com.example.demo.entity.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Result)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-02 09:15:39
 */
public interface ResultDao {

    /**
     * 通过ID查询单条数据
     *
     * @param resultId 主键
     * @return 实例对象
     */
    Result queryById(Integer resultId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Result> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param result 实例对象
     * @return 对象列表
     */
    List<Result> queryAll(Result result);

    /**
     * 新增数据
     *
     * @param result 实例对象
     * @return 影响行数
     */
    int insert(Result result);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Result> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Result> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Result> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Result> entities);

    /**
     * 修改数据
     *
     * @param result 实例对象
     * @return 影响行数
     */
    int update(Result result);

    /**
     * 通过主键删除数据
     *
     * @param resultId 主键
     * @return 影响行数
     */
    int deleteById(Integer resultId);

}