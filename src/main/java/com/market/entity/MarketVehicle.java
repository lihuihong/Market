package com.market.entity;

import java.io.Serializable;

public class MarketVehicle implements Serializable {
    private Integer vehicleId;

    private String vehicleName;

    private String vehicleType;

    private String vehicleColor;

    private String vehicleNumber;

    private static final long serialVersionUID = 1L;

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName == null ? null : vehicleName.trim();
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType == null ? null : vehicleType.trim();
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor == null ? null : vehicleColor.trim();
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber == null ? null : vehicleNumber.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", vehicleId=").append(vehicleId);
        sb.append(", vehicleName=").append(vehicleName);
        sb.append(", vehicleType=").append(vehicleType);
        sb.append(", vehicleColor=").append(vehicleColor);
        sb.append(", vehicleNumber=").append(vehicleNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}