package com.example.carslistapp;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "workdays",
        "weekends",
        "kilometerPrice",
        "freeKilometersPerDay",
        "servicePlusBatteryMaxKm",
        "servicePlusBatteryMinKm",
        "servicePlusEGoPoints"
})
public class Lease {

    @JsonProperty("workdays")
    private Workdays workdays;
    @JsonProperty("weekends")
    private Weekends weekends;
    @JsonProperty("kilometerPrice")
    private float kilometerPrice;
    @JsonProperty("freeKilometersPerDay")
    private Integer freeKilometersPerDay;
    @JsonProperty("servicePlusBatteryMaxKm")
    private Integer servicePlusBatteryMaxKm;
    @JsonProperty("servicePlusBatteryMinKm")
    private Integer servicePlusBatteryMinKm;
    @JsonProperty("servicePlusEGoPoints")
    private Integer servicePlusEGoPoints;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("workdays")
    public Workdays getWorkdays() {
        return workdays;
    }

    @JsonProperty("workdays")
    public void setWorkdays(Workdays workdays) {
        this.workdays = workdays;
    }

    @JsonProperty("weekends")
    public Weekends getWeekends() {
        return weekends;
    }

    @JsonProperty("weekends")
    public void setWeekends(Weekends weekends) {
        this.weekends = weekends;
    }

    @JsonProperty("kilometerPrice")
    public Float getKilometerPrice() {
        return kilometerPrice;
    }

    @JsonProperty("kilometerPrice")
    public void setKilometerPrice(Integer kilometerPrice) {
        this.kilometerPrice = kilometerPrice;
    }

    @JsonProperty("freeKilometersPerDay")
    public Integer getFreeKilometersPerDay() {
        return freeKilometersPerDay;
    }

    @JsonProperty("freeKilometersPerDay")
    public void setFreeKilometersPerDay(Integer freeKilometersPerDay) {
        this.freeKilometersPerDay = freeKilometersPerDay;
    }

    @JsonProperty("servicePlusBatteryMaxKm")
    public Integer getServicePlusBatteryMaxKm() {
        return servicePlusBatteryMaxKm;
    }

    @JsonProperty("servicePlusBatteryMaxKm")
    public void setServicePlusBatteryMaxKm(Integer servicePlusBatteryMaxKm) {
        this.servicePlusBatteryMaxKm = servicePlusBatteryMaxKm;
    }

    @JsonProperty("servicePlusBatteryMinKm")
    public Integer getServicePlusBatteryMinKm() {
        return servicePlusBatteryMinKm;
    }

    @JsonProperty("servicePlusBatteryMinKm")
    public void setServicePlusBatteryMinKm(Integer servicePlusBatteryMinKm) {
        this.servicePlusBatteryMinKm = servicePlusBatteryMinKm;
    }

    @JsonProperty("servicePlusEGoPoints")
    public Integer getServicePlusEGoPoints() {
        return servicePlusEGoPoints;
    }

    @JsonProperty("servicePlusEGoPoints")
    public void setServicePlusEGoPoints(Integer servicePlusEGoPoints) {
        this.servicePlusEGoPoints = servicePlusEGoPoints;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}