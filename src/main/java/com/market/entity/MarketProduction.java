package com.market.entity;

import java.io.Serializable;

public class MarketProduction implements Serializable {
    private Integer productionId;

    private Integer vehicleId;
    private Integer productionNumber;
    private Integer productionVolume;
    private Integer productionPrice;
    private MarketVehicle vehicle;


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

    public Integer getProductionNumber() {
        return productionNumber;
    }

    public void setProductionNumber(Integer productionNumber) {
        this.productionNumber = productionNumber;
    }

    public Integer getProductionVolume() {
        return productionVolume;
    }

    public void setProductionVolume(Integer productionVolume) {
        this.productionVolume = productionVolume;
    }

    public Integer getProductionPrice() {
        return productionPrice;
    }

    public void setProductionPrice(Integer productionPrice) {
        this.productionPrice = productionPrice;
    }

    public MarketVehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(MarketVehicle vehicle) {
        this.vehicle = vehicle;
    }
}