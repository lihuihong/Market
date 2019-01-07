package com.market.entity;

import java.io.Serializable;
import java.util.Date;

public class MarketSurvey implements Serializable {
    private Integer surveyId;

    private String surveyName;

    private String surveyDesc;

    private Integer userId;

    private Date surveyTime;

    private static final long serialVersionUID = 1L;

    public Integer getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Integer surveyId) {
        this.surveyId = surveyId;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public String getSurveyDesc() {
        return surveyDesc;
    }

    public void setSurveyDesc(String surveyDesc) {
        this.surveyDesc = surveyDesc;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getSurveyTime() {
        return surveyTime;
    }

    public void setSurveyTime(Date surveyTime) {
        this.surveyTime = surveyTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", surveyId=").append(surveyId);
        sb.append(", surveyName=").append(surveyName);
        sb.append(", surveyDesc=").append(surveyDesc);
        sb.append(", userId=").append(userId);
        sb.append(", surveyTime=").append(surveyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}