package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * (Question)实体类
 *
 * @author makejava
 * @since 2020-11-02 09:02:50
 */
public class Question implements Serializable {
    private static final long serialVersionUID = 213161688985118228L;

    @JsonProperty(value = "questionId")
    private Integer questionId;

    @JsonProperty(value = "questionContent")
    private String questionContent;

    @JsonProperty(value = "questionType")
    private String questionType;

    @JsonProperty(value = "questionQuestionnaireId")
    private Integer questionQuestionnaireId;

    private List<Option> options;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public Integer getQuestionQuestionnaireId() {
        return questionQuestionnaireId;
    }

    public void setQuestionQuestionnaireId(Integer questionQuestionnaireId) {
        this.questionQuestionnaireId = questionQuestionnaireId;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}