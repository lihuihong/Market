package com.market.entity;

import java.io.Serializable;

public class MarketPlaying implements Serializable {
    private Integer playingId;

    private Integer vehicleId;

    private String playingNumber;

    private String playingAddress;

    private static final long serialVersionUID = 1L;

    public Integer getPlayingId() {
        return playingId;
    }

    public void setPlayingId(Integer playingId) {
        this.playingId = playingId;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getPlayingNumber() {
        return playingNumber;
    }

    public void setPlayingNumber(String playingNumber) {
        this.playingNumber = playingNumber == null ? null : playingNumber.trim();
    }

    public String getPlayingAddress() {
        return playingAddress;
    }

    public void setPlayingAddress(String playingAddress) {
        this.playingAddress = playingAddress == null ? null : playingAddress.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", playingId=").append(playingId);
        sb.append(", vehicleId=").append(vehicleId);
        sb.append(", playingNumber=").append(playingNumber);
        sb.append(", playingAddress=").append(playingAddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}