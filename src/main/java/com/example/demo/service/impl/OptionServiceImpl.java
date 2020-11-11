package com.example.demo.service.impl;

import com.example.demo.dao.OptionDao;
import com.example.demo.entity.Option;
import com.example.demo.service.OptionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Option)表服务实现类
 *
 * @author makejava
 * @since 2020-11-02 09:02:49
 */
@Service("optionService")
public class OptionServiceImpl implements OptionService {
    @Resource
    private OptionDao optionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param optionId 主键
     * @return 实例对象
     */
    @Override
    public Option queryById(Integer optionId) {
        return this.optionDao.queryById(optionId);
    }

    /**
     * 通过外键查询多条数据
     *
     * @param questionId 外键
     * @return 对象列表
     */
    @Override
    public List<Option> queryAllByQuestionId(Integer questionId) {
        return this.optionDao.queryAllByQuestionId(questionId);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param option 实例对象
     * @return 对象列表
     */
    public List<Option> queryAll(Option option) {
        return this.optionDao.queryAll(option);
    }

    /**
     * 新增数据
     *
     * @param option 实例对象
     * @return 实例对象
     */
    @Override
    public Option insert(Option option) {
        this.optionDao.insert(option);
        return option;
    }

    /**
     * 修改数据
     *
     * @param option 实例对象
     * @return 实例对象
     */
    @Override
    public Option update(Option option) {
        this.optionDao.update(option);
        return this.queryById(option.getOptionId());
    }

    /**
     * 通过主键删除数据
     *
     * @param optionId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer optionId) {
        return this.optionDao.deleteById(optionId);
    }
}