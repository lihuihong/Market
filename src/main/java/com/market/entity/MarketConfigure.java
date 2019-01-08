package com.market.entity;

import java.io.Serializable;

public class MarketConfigure implements Serializable {
    private Integer configureId;

    private Integer vehicleId;

    private String configurePedal;

    private String configureSeat;

    private String configurePick;

    private String configureMirror;

    private String configureTyre;

    private String configureCompass;

    private String configureHeadlamps;

    private MarketVehicle vehicle;

    public MarketVehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(MarketVehicle vehicle) {
        this.vehicle = vehicle;
    }

    private static final long serialVersionUID = 1L;

    public Integer getConfigureId() {
        return configureId;
    }

    public void setConfigureId(Integer configureId) {
        this.configureId = configureId;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getConfigurePedal() {
        return configurePedal;
    }

    public void setConfigurePedal(String configurePedal) {
        this.configurePedal = configurePedal == null ? null : configurePedal.trim();
    }

    public String getConfigureSeat() {
        return configureSeat;
    }

    public void setConfigureSeat(String configureSeat) {
        this.configureSeat = configureSeat == null ? null : configureSeat.trim();
    }

    public String getConfigurePick() {
        return configurePick;
    }

    public void setConfigurePick(String configurePick) {
        this.configurePick = configurePick == null ? null : configurePick.trim();
    }

    public String getConfigureMirror() {
        return configureMirror;
    }

    public void setConfigureMirror(String configureMirror) {
        this.configureMirror = configureMirror == null ? null : configureMirror.trim();
    }

    public String getConfigureTyre() {
        return configureTyre;
    }

    public void setConfigureTyre(String configureTyre) {
        this.configureTyre = configureTyre == null ? null : configureTyre.trim();
    }

    public String getConfigureCompass() {
        return configureCompass;
    }

    public void setConfigureCompass(String configureCompass) {
        this.configureCompass = configureCompass == null ? null : configureCompass.trim();
    }

    public String getConfigureHeadlamps() {
        return configureHeadlamps;
    }

    public void setConfigureHeadlamps(String configureHeadlamps) {
        this.configureHeadlamps = configureHeadlamps == null ? null : configureHeadlamps.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", configureId=").append(configureId);
        sb.append(", vehicleId=").append(vehicleId);
        sb.append(", configurePedal=").append(configurePedal);
        sb.append(", configureSeat=").append(configureSeat);
        sb.append(", configurePick=").append(configurePick);
        sb.append(", configureMirror=").append(configureMirror);
        sb.append(", configureTyre=").append(configureTyre);
        sb.append(", configureCompass=").append(configureCompass);
        sb.append(", configureHeadlamps=").append(configureHeadlamps);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}