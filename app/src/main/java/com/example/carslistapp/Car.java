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
        "id",
        "plateNumber",
        "location",
        "model",
        "batteryPercentage",
        "batteryEstimatedDistance",
        "isCharging"
})
public class Car  {


    public Car ( Model model, Location location, String plateNumber, Integer batteryPercentage ){
        this.model = model;
        this.location = location;
        this.plateNumber = plateNumber;
        this.batteryPercentage = batteryPercentage;
    }


    @JsonProperty("id")
    private Integer id;
    @JsonProperty("plateNumber")
    private String plateNumber;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("model")
    private Model model;
    @JsonProperty("batteryPercentage")
    private Integer batteryPercentage;
    @JsonProperty("batteryEstimatedDistance")
    private Integer batteryEstimatedDistance;
    @JsonProperty("isCharging")
    private Boolean isCharging;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("plateNumber")
    public String getPlateNumber() {
        return plateNumber;
    }

    @JsonProperty("plateNumber")
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("model")
    public Model getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(Model model) {
        this.model = model;
    }

    @JsonProperty("batteryPercentage")
    public Integer getBatteryPercentage() {
        return batteryPercentage;
    }

    @JsonProperty("batteryPercentage")
    public void setBatteryPercentage(Integer batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    @JsonProperty("batteryEstimatedDistance")
    public Integer getBatteryEstimatedDistance() {
        return batteryEstimatedDistance;
    }

    @JsonProperty("batteryEstimatedDistance")
    public void setBatteryEstimatedDistance(Integer batteryEstimatedDistance) {
        this.batteryEstimatedDistance = batteryEstimatedDistance;
    }

    @JsonProperty("isCharging")
    public Boolean getIsCharging() {
        return isCharging;
    }

    @JsonProperty("isCharging")
    public void setIsCharging(Boolean isCharging) {
        this.isCharging = isCharging;
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