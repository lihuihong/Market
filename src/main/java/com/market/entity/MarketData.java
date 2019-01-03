package com.market.entity;

import java.io.Serializable;

public class MarketData implements Serializable {
    private Integer dataId;

    private Integer vehicleId;

    private String dataEngine;

    private String dataPower;

    private String dataTorque;

    private String dataCase;

    private String dataSpeed;

    private static final long serialVersionUID = 1L;

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDataEngine() {
        return dataEngine;
    }

    public void setDataEngine(String dataEngine) {
        this.dataEngine = dataEngine == null ? null : dataEngine.trim();
    }

    public String getDataPower() {
        return dataPower;
    }

    public void setDataPower(String dataPower) {
        this.dataPower = dataPower == null ? null : dataPower.trim();
    }

    public String getDataTorque() {
        return dataTorque;
    }

    public void setDataTorque(String dataTorque) {
        this.dataTorque = dataTorque == null ? null : dataTorque.trim();
    }

    public String getDataCase() {
        return dataCase;
    }

    public void setDataCase(String dataCase) {
        this.dataCase = dataCase == null ? null : dataCase.trim();
    }

    public String getDataSpeed() {
        return dataSpeed;
    }

    public void setDataSpeed(String dataSpeed) {
        this.dataSpeed = dataSpeed == null ? null : dataSpeed.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", vehicleId=").append(vehicleId);
        sb.append(", dataEngine=").append(dataEngine);
        sb.append(", dataPower=").append(dataPower);
        sb.append(", dataTorque=").append(dataTorque);
        sb.append(", dataCase=").append(dataCase);
        sb.append(", dataSpeed=").append(dataSpeed);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}