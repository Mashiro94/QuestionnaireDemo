package com.example.demo.service.impl;

import com.example.demo.dao.OptionDao;
import com.example.demo.dao.QuestionDao;
import com.example.demo.entity.Question;
import com.example.demo.service.QuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Question)表服务实现类
 *
 * @author makejava
 * @since 2020-11-02 09:02:50
 */
@Service("questionService")
public class QuestionServiceImpl implements QuestionService {
    @Resource
    private QuestionDao questionDao;
    @Resource
    private OptionDao optionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param questionId 主键
     * @return 实例对象
     */
    @Override
    public Question queryById(Integer questionId) {
        Question question = this.questionDao.queryById(questionId);
        question.setOptions(this.optionDao.queryAllByQuestionId(questionId));
        return question;
    }

    /**
     * 查询多条数据
     *
     * @param questionnaireId 外键
     * @return 对象列表
     */
    @Override
    public List<Question> queryAllByQuestionnaireId(Integer questionnaireId) {
        return this.questionDao.queryAllByQuestionnaireId(questionnaireId);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param question 实例对象
     * @return 对象列表
     */
    @Override
    public List<Question> queryAll(Question question) {
        return this.questionDao.queryAll(question);
    }

    /**
     * 新增数据
     *
     * @param question 实例对象
     * @return 实例对象
     */
    @Override
    public Question insert(Question question) {
        this.questionDao.insert(question);
        return question;
    }

    /**
     * 修改数据
     *
     * @param question 实例对象
     * @return 实例对象
     */
    @Override
    public Question update(Question question) {
        this.questionDao.update(question);
        return this.queryById(question.getQuestionId());
    }

    /**
     * 通过主键删除数据
     *
     * @param questionId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer questionId) {
        return this.questionDao.deleteById(questionId);
    }
}