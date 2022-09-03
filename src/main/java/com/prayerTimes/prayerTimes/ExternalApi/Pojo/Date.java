
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
    "readable",
    "timestamp",
    "gregorian",
    "hijri"
})
@Generated("jsonschema2pojo")
public class Date {

    @JsonProperty("readable")
    private String readable;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("gregorian")
    private Gregorian gregorian;
    @JsonProperty("hijri")
    private Hijri hijri;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("readable")
    public String getReadable() {
        return readable;
    }

    @JsonProperty("readable")
    public void setReadable(String readable) {
        this.readable = readable;
    }

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("gregorian")
    public Gregorian getGregorian() {
        return gregorian;
    }

    @JsonProperty("gregorian")
    public void setGregorian(Gregorian gregorian) {
        this.gregorian = gregorian;
    }

    @JsonProperty("hijri")
    public Hijri getHijri() {
        return hijri;
    }

    @JsonProperty("hijri")
    public void setHijri(Hijri hijri) {
        this.hijri = hijri;
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
