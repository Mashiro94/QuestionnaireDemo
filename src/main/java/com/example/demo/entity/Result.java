package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * (Result)实体类
 *
 * @author makejava
 * @since 2020-11-02 09:15:39
 */
public class Result implements Serializable {
    private static final long serialVersionUID = -73204348316993163L;

    @JsonProperty(value = "resultId")
    private Integer resultId;

    @JsonProperty(value = "resultQuestionId")
    private Integer resultQuestionId;

    @JsonProperty(value = "resultUserId")
    private Integer resultUserId;

    @JsonProperty(value = "resultContent")
    private String resultContent;

    private String resultQuestionContent;

    private List<String> resultOptionContent;

    public Result() {

    }

    public Result(Integer resultQuestionId) {
        this.resultQuestionId = resultQuestionId;
    }

    public Result(Integer resultQuestionId, Integer resultUserId) {
        this.resultQuestionId = resultQuestionId;
        this.resultUserId = resultUserId;
    }

    public String getResultQuestionContent() {
        return resultQuestionContent;
    }

    public void setResultQuestionContent(String resultQuestionContent) {
        this.resultQuestionContent = resultQuestionContent;
    }

    public List<String> getResultOptionContent() {
        return resultOptionContent;
    }

    public void setResultOptionContent(List<String> resultOptionContent) {
        this.resultOptionContent = resultOptionContent;
    }

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