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
        "initialPrice",
        "initialMinutes",
        "extensionPrice",
        "extensionMinutes",
        "longerExtensionPrice",
        "longerExtensionMinutes"
})
public class Reservation {

    @JsonProperty("initialPrice")
    private Integer initialPrice;
    @JsonProperty("initialMinutes")
    private Integer initialMinutes;
    @JsonProperty("extensionPrice")
    private Integer extensionPrice;
    @JsonProperty("extensionMinutes")
    private Integer extensionMinutes;
    @JsonProperty("longerExtensionPrice")
    private Integer longerExtensionPrice;
    @JsonProperty("longerExtensionMinutes")
    private Integer longerExtensionMinutes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("initialPrice")
    public Integer getInitialPrice() {
        return initialPrice;
    }

    @JsonProperty("initialPrice")
    public void setInitialPrice(Integer initialPrice) {
        this.initialPrice = initialPrice;
    }

    @JsonProperty("initialMinutes")
    public Integer getInitialMinutes() {
        return initialMinutes;
    }

    @JsonProperty("initialMinutes")
    public void setInitialMinutes(Integer initialMinutes) {
        this.initialMinutes = initialMinutes;
    }

    @JsonProperty("extensionPrice")
    public Integer getExtensionPrice() {
        return extensionPrice;
    }

    @JsonProperty("extensionPrice")
    public void setExtensionPrice(Integer extensionPrice) {
        this.extensionPrice = extensionPrice;
    }

    @JsonProperty("extensionMinutes")
    public Integer getExtensionMinutes() {
        return extensionMinutes;
    }

    @JsonProperty("extensionMinutes")
    public void setExtensionMinutes(Integer extensionMinutes) {
        this.extensionMinutes = extensionMinutes;
    }

    @JsonProperty("longerExtensionPrice")
    public Integer getLongerExtensionPrice() {
        return longerExtensionPrice;
    }

    @JsonProperty("longerExtensionPrice")
    public void setLongerExtensionPrice(Integer longerExtensionPrice) {
        this.longerExtensionPrice = longerExtensionPrice;
    }

    @JsonProperty("longerExtensionMinutes")
    public Integer getLongerExtensionMinutes() {
        return longerExtensionMinutes;
    }

    @JsonProperty("longerExtensionMinutes")
    public void setLongerExtensionMinutes(Integer longerExtensionMinutes) {
        this.longerExtensionMinutes = longerExtensionMinutes;
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