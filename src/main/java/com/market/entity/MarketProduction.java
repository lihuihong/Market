package com.market.entity;

import java.io.Serializable;

public class MarketProduction implements Serializable {
    private Integer productionId;

    private Integer vehicleId;

    private String productionNumber;

    private String productionVolume;

    private static final long serialVersionUID = 1L;

    public Integer getProductionId() {
        return productionId;
    }

    public void setProductionId(Integer productionId) {
        this.productionId = productionId;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getProductionNumber() {
        return productionNumber;
    }

    public void setProductionNumber(String productionNumber) {
        this.productionNumber = productionNumber == null ? null : productionNumber.trim();
    }

    public String getProductionVolume() {
        return productionVolume;
    }

    public void setProductionVolume(String productionVolume) {
        this.productionVolume = productionVolume == null ? null : productionVolume.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productionId=").append(productionId);
        sb.append(", vehicleId=").append(vehicleId);
        sb.append(", productionNumber=").append(productionNumber);
        sb.append(", productionVolume=").append(productionVolume);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}