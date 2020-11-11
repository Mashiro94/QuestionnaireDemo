package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * (Questionnaire)实体类
 *
 * @author makejava
 * @since 2020-11-02 09:02:50
 */
public class Questionnaire implements Serializable {
    private static final long serialVersionUID = 916543379017406025L;

    @JsonProperty(value = "questionnaireId")
    private Integer questionnaireId;

    @JsonProperty(value = "questionnaireName")
    private String questionnaireName;

    @JsonProperty(value = "questionnaireDescription")
    private String questionnaireDescription;

    private List<Question> questions;

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public void setQuestionnaireName(String questionnaireName) {
        this.questionnaireName = questionnaireName;
    }

    public String getQuestionnaireDescription() {
        return questionnaireDescription;
    }

    public void setQuestionnaireDescription(String questionnaireDescription) {
        this.questionnaireDescription = questionnaireDescription;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}