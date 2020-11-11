package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * (Option)实体类
 *
 * @author makejava
 * @since 2020-11-02 09:02:49
 */
public class Option implements Serializable {
    private static final long serialVersionUID = 511103450362462048L;

    @JsonProperty(value = "optionId")
    private Integer optionId;

    @JsonProperty(value = "optionQuestionId")
    private Integer optionQuestionId;

    @JsonProperty(value = "optionContent")
    private String optionContent;

    @JsonProperty(value = "optionValue")
    private Integer optionValue;

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public Integer getOptionQuestionId() {
        return optionQuestionId;
    }

    public void setOptionQuestionId(Integer optionQuestionId) {
        this.optionQuestionId = optionQuestionId;
    }

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent;
    }

    public Integer getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(Integer optionValue) {
        this.optionValue = optionValue;
    }

}