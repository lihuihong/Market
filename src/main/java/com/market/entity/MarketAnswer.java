package com.market.entity;

import java.io.Serializable;
import java.util.Date;

public class MarketAnswer implements Serializable {

    private Integer answerId;
    private Integer surveyId;
    private MarketSurvey survey;
    private Integer questionId;
    private MarketQuestion question;

    private Integer userId;
    private User user;

    private String answerContent;

    private Date answerTime;

    private static final long serialVersionUID = 1L;

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Integer surveyId) {
        this.surveyId = surveyId;
    }

    public MarketSurvey getSurvey() {
        return survey;
    }

    public void setSurvey(MarketSurvey survey) {
        this.survey = survey;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public MarketQuestion getQuestion() {
        return question;
    }

    public void setQuestion(MarketQuestion question) {
        this.question = question;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", answerId=").append(answerId);
        sb.append(", surveyId=").append(surveyId);
        sb.append(", answerContent=").append(answerContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}