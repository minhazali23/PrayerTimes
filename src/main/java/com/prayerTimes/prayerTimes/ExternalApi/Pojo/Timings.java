
package com.prayerTimes.prayerTimes.ExternalApi.Pojo;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Fajr",
    "Sunrise",
    "Dhuhr",
    "Asr",
    "Sunset",
    "Maghrib",
    "Isha",
    "Imsak",
    "Midnight",
    "Firstthird",
    "Lastthird"
})
@Generated("jsonschema2pojo")
public class Timings {

    @JsonProperty("Fajr")
    private String fajr;
    @JsonProperty("Sunrise")
    private String sunrise;
    @JsonProperty("Dhuhr")
    private String dhuhr;
    @JsonProperty("Asr")
    private String asr;
    @JsonProperty("Sunset")
    private String sunset;
    @JsonProperty("Maghrib")
    private String maghrib;
    @JsonProperty("Isha")
    private String isha;
    @JsonProperty("Imsak")
    private String imsak;
    @JsonProperty("Midnight")
    private String midnight;
    @JsonProperty("Firstthird")
    private String firstthird;
    @JsonProperty("Lastthird")
    private String lastthird;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Fajr")
    public String getFajr() {
        return fajr;
    }

    @JsonProperty("Fajr")
    public void setFajr(String fajr) {
        this.fajr = fajr;
    }

    @JsonProperty("Sunrise")
    public String getSunrise() {
        return sunrise;
    }

    @JsonProperty("Sunrise")
    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    @JsonProperty("Dhuhr")
    public String getDhuhr() {
        return dhuhr;
    }

    @JsonProperty("Dhuhr")
    public void setDhuhr(String dhuhr) {
        this.dhuhr = dhuhr;
    }

    @JsonProperty("Asr")
    public String getAsr() {
        return asr;
    }

    @JsonProperty("Asr")
    public void setAsr(String asr) {
        this.asr = asr;
    }

    @JsonProperty("Sunset")
    public String getSunset() {
        return sunset;
    }

    @JsonProperty("Sunset")
    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    @JsonProperty("Maghrib")
    public String getMaghrib() {
        return maghrib;
    }

    @JsonProperty("Maghrib")
    public void setMaghrib(String maghrib) {
        this.maghrib = maghrib;
    }

    @JsonProperty("Isha")
    public String getIsha() {
        return isha;
    }

    @JsonProperty("Isha")
    public void setIsha(String isha) {
        this.isha = isha;
    }

    @JsonProperty("Imsak")
    public String getImsak() {
        return imsak;
    }

    @JsonProperty("Imsak")
    public void setImsak(String imsak) {
        this.imsak = imsak;
    }

    @JsonProperty("Midnight")
    public String getMidnight() {
        return midnight;
    }

    @JsonProperty("Midnight")
    public void setMidnight(String midnight) {
        this.midnight = midnight;
    }

    @JsonProperty("Firstthird")
    public String getFirstthird() {
        return firstthird;
    }

    @JsonProperty("Firstthird")
    public void setFirstthird(String firstthird) {
        this.firstthird = firstthird;
    }

    @JsonProperty("Lastthird")
    public String getLastthird() {
        return lastthird;
    }

    @JsonProperty("Lastthird")
    public void setLastthird(String lastthird) {
        this.lastthird = lastthird;
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
