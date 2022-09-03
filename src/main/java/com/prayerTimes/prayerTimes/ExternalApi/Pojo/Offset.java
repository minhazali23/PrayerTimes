
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
    "Imsak",
    "Fajr",
    "Sunrise",
    "Dhuhr",
    "Asr",
    "Maghrib",
    "Sunset",
    "Isha",
    "Midnight"
})
@Generated("jsonschema2pojo")
public class Offset {

    @JsonProperty("Imsak")
    private Integer imsak;
    @JsonProperty("Fajr")
    private Integer fajr;
    @JsonProperty("Sunrise")
    private Integer sunrise;
    @JsonProperty("Dhuhr")
    private Integer dhuhr;
    @JsonProperty("Asr")
    private Integer asr;
    @JsonProperty("Maghrib")
    private Integer maghrib;
    @JsonProperty("Sunset")
    private Integer sunset;
    @JsonProperty("Isha")
    private Integer isha;
    @JsonProperty("Midnight")
    private Integer midnight;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Imsak")
    public Integer getImsak() {
        return imsak;
    }

    @JsonProperty("Imsak")
    public void setImsak(Integer imsak) {
        this.imsak = imsak;
    }

    @JsonProperty("Fajr")
    public Integer getFajr() {
        return fajr;
    }

    @JsonProperty("Fajr")
    public void setFajr(Integer fajr) {
        this.fajr = fajr;
    }

    @JsonProperty("Sunrise")
    public Integer getSunrise() {
        return sunrise;
    }

    @JsonProperty("Sunrise")
    public void setSunrise(Integer sunrise) {
        this.sunrise = sunrise;
    }

    @JsonProperty("Dhuhr")
    public Integer getDhuhr() {
        return dhuhr;
    }

    @JsonProperty("Dhuhr")
    public void setDhuhr(Integer dhuhr) {
        this.dhuhr = dhuhr;
    }

    @JsonProperty("Asr")
    public Integer getAsr() {
        return asr;
    }

    @JsonProperty("Asr")
    public void setAsr(Integer asr) {
        this.asr = asr;
    }

    @JsonProperty("Maghrib")
    public Integer getMaghrib() {
        return maghrib;
    }

    @JsonProperty("Maghrib")
    public void setMaghrib(Integer maghrib) {
        this.maghrib = maghrib;
    }

    @JsonProperty("Sunset")
    public Integer getSunset() {
        return sunset;
    }

    @JsonProperty("Sunset")
    public void setSunset(Integer sunset) {
        this.sunset = sunset;
    }

    @JsonProperty("Isha")
    public Integer getIsha() {
        return isha;
    }

    @JsonProperty("Isha")
    public void setIsha(Integer isha) {
        this.isha = isha;
    }

    @JsonProperty("Midnight")
    public Integer getMidnight() {
        return midnight;
    }

    @JsonProperty("Midnight")
    public void setMidnight(Integer midnight) {
        this.midnight = midnight;
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
