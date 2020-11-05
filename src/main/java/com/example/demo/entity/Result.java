package com.example.demo.entity;

import java.io.Serializable;

/**
 * (Result)实体类
 *
 * @author makejava
 * @since 2020-11-02 09:15:39
 */
public class Result implements Serializable {
    private static final long serialVersionUID = -73204348316993163L;

    private Integer resultId;

    private Integer resultQuestionId;

    private Integer resultUserId;

    private String resultContent;


    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public Integer getResultQuestionId() {
        return resultQuestionId;
    }

    public void setResultQuestionId(Integer resultQuestionId) {
        this.resultQuestionId = resultQuestionId;
    }

    public Integer getResultUserId() {
        return resultUserId;
    }

    public void setResultUserId(Integer resultUserId) {
        this.resultUserId = resultUserId;
    }

    public String getResultContent() {
        return resultContent;
    }

    public void setResultContent(String resultContent) {
        this.resultContent = resultContent;
    }

}