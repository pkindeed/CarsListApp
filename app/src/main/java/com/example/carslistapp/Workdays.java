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
        "amount",
        "minutes",
        "dailyAmount",
        "minimumPrice",
        "minimumMinutes"
})
public class Workdays {

    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("minutes")
    private Integer minutes;
    @JsonProperty("dailyAmount")
    private Integer dailyAmount;
    @JsonProperty("minimumPrice")
    private Double minimumPrice;
    @JsonProperty("minimumMinutes")
    private Integer minimumMinutes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("amount")
    public Double getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @JsonProperty("minutes")
    public Integer getMinutes() {
        return minutes;
    }

    @JsonProperty("minutes")
    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    @JsonProperty("dailyAmount")
    public Integer getDailyAmount() {
        return dailyAmount;
    }

    @JsonProperty("dailyAmount")
    public void setDailyAmount(Integer dailyAmount) {
        this.dailyAmount = dailyAmount;
    }

    @JsonProperty("minimumPrice")
    public Double getMinimumPrice() {
        return minimumPrice;
    }

    @JsonProperty("minimumPrice")
    public void setMinimumPrice(Double minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    @JsonProperty("minimumMinutes")
    public Integer getMinimumMinutes() {
        return minimumMinutes;
    }

    @JsonProperty("minimumMinutes")
    public void setMinimumMinutes(Integer minimumMinutes) {
        this.minimumMinutes = minimumMinutes;
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