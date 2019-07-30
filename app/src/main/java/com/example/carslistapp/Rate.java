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
        "isWeekend",
        "currency",
        "currencySymbol",
        "lease",
        "reservation"
})
public class Rate {

    @JsonProperty("isWeekend")
    private Boolean isWeekend;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("currencySymbol")
    private String currencySymbol;
    @JsonProperty("lease")
    private Lease lease;
    @JsonProperty("reservation")
    private Reservation reservation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("isWeekend")
    public Boolean getIsWeekend() {
        return isWeekend;
    }

    @JsonProperty("isWeekend")
    public void setIsWeekend(Boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("currencySymbol")
    public String getCurrencySymbol() {
        return currencySymbol;
    }

    @JsonProperty("currencySymbol")
    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    @JsonProperty("lease")
    public Lease getLease() {
        return lease;
    }

    @JsonProperty("lease")
    public void setLease(Lease lease) {
        this.lease = lease;
    }

    @JsonProperty("reservation")
    public Reservation getReservation() {
        return reservation;
    }

    @JsonProperty("reservation")
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
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