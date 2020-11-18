package com.example.demo.service.impl;

import com.example.demo.dao.ResultDao;
import com.example.demo.entity.Result;
import com.example.demo.service.ResultService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Result)表服务实现类
 *
 * @author makejava
 * @since 2020-11-02 09:15:39
 */
@Service("resultService")
public class ResultServiceImpl implements ResultService {
    @Resource
    private ResultDao resultDao;

    /**
     * 通过ID查询单条数据
     *
     * @param resultId 主键
     * @return 实例对象
     */
    @Override
    public Result queryById(Integer resultId) {
        return this.resultDao.queryById(resultId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Result> queryAllByLimit(int offset, int limit) {
        return this.resultDao.queryAllByLimit(offset, limit);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param result 实例对象
     * @return 对象列表
     */
    @Override
    public List<Result> queryAll(Result result) {
        return this.resultDao.queryAll(result);
    }

    /**
     * 新增数据
     *
     * @param result 实例对象
     * @return 实例对象
     */
    @Override
    public Result insert(Result result) {
        this.resultDao.insert(result);
        return result;
    }

    /**
     * 修改数据
     *
     * @param result 实例对象
     * @return 实例对象
     */
    @Override
    public Result update(Result result) {
        this.resultDao.update(result);
        return this.queryById(result.getResultId());
    }

    /**
     * 通过主键删除数据
     *
     * @param resultId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer resultId) {
        return this.resultDao.deleteById(resultId) > 0;
    }
}