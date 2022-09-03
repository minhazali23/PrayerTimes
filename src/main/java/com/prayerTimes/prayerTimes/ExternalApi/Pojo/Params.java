
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
    "Isha"
})
@Generated("jsonschema2pojo")
public class Params {

    @JsonProperty("Fajr")
    private Integer fajr;
    @JsonProperty("Isha")
    private Integer isha;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Fajr")
    public Integer getFajr() {
        return fajr;
    }

    @JsonProperty("Fajr")
    public void setFajr(Integer fajr) {
        this.fajr = fajr;
    }

    @JsonProperty("Isha")
    public Integer getIsha() {
        return isha;
    }

    @JsonProperty("Isha")
    public void setIsha(Integer isha) {
        this.isha = isha;
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
