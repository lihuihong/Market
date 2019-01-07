package com.market.entity;

import java.io.Serializable;
import java.util.Date;

public class MarketQuestion implements Serializable {

    private Integer questionId;

    private Integer surveyId;

    private String questionContent;

    private String questionType;

    private String questionA;

    private String questionB;

    private String questionC;

    private String questionD;

    private Date questionTime;

    private static final long serialVersionUID = 1L;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Integer surveyId) {
        this.surveyId = surveyId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent == null ? null : questionContent.trim();
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType == null ? null : questionType.trim();
    }

    public String getQuestionA() {
        return questionA;
    }

    public void setQuestionA(String questionA) {
        this.questionA = questionA == null ? null : questionA.trim();
    }

    public String getQuestionB() {
        return questionB;
    }

    public void setQuestionB(String questionB) {
        this.questionB = questionB == null ? null : questionB.trim();
    }

    public String getQuestionC() {
        return questionC;
    }

    public void setQuestionC(String questionC) {
        this.questionC = questionC == null ? null : questionC.trim();
    }

    public String getQuestionD() {
        return questionD;
    }

    public void setQuestionD(String questionD) {
        this.questionD = questionD == null ? null : questionD.trim();
    }

    public Date getQuestionTime() {
        return questionTime;
    }

    public void setQuestionTime(Date questionTime) {
        this.questionTime = questionTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", questionId=").append(questionId);
        sb.append(", surveyId=").append(surveyId);
        sb.append(", questionContent=").append(questionContent);
        sb.append(", questionType=").append(questionType);
        sb.append(", questionA=").append(questionA);
        sb.append(", questionB=").append(questionB);
        sb.append(", questionC=").append(questionC);
        sb.append(", questionD=").append(questionD);
        sb.append(", questionTime=").append(questionTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}