package com.market.entity;

import java.io.Serializable;
import java.util.Date;

public class MarketPre implements Serializable {
    private Integer preId;

    private Integer userId;

    private String preName;

    private String preType;

    private Date preTime;

    private static final long serialVersionUID = 1L;

    public Integer getPreId() {
        return preId;
    }

    public void setPreId(Integer preId) {
        this.preId = preId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPreName() {
        return preName;
    }

    public void setPreName(String preName) {
        this.preName = preName == null ? null : preName.trim();
    }

    public String getPreType() {
        return preType;
    }

    public void setPreType(String preType) {
        this.preType = preType == null ? null : preType.trim();
    }

    public Date getPreTime() {
        return preTime;
    }

    public void setPreTime(Date preTime) {
        this.preTime = preTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", preId=").append(preId);
        sb.append(", userId=").append(userId);
        sb.append(", preName=").append(preName);
        sb.append(", preType=").append(preType);
        sb.append(", preTime=").append(preTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}