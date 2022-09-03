
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
    "date",
    "format",
    "day",
    "weekday",
    "month",
    "year",
    "designation"
})
@Generated("jsonschema2pojo")
public class Gregorian {

    @JsonProperty("date")
    private String date;
    @JsonProperty("format")
    private String format;
    @JsonProperty("day")
    private String day;
    @JsonProperty("weekday")
    private Weekday weekday;
    @JsonProperty("month")
    private Month month;
    @JsonProperty("year")
    private String year;
    @JsonProperty("designation")
    private Designation designation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    @JsonProperty("day")
    public String getDay() {
        return day;
    }

    @JsonProperty("day")
    public void setDay(String day) {
        this.day = day;
    }

    @JsonProperty("weekday")
    public Weekday getWeekday() {
        return weekday;
    }

    @JsonProperty("weekday")
    public void setWeekday(Weekday weekday) {
        this.weekday = weekday;
    }

    @JsonProperty("month")
    public Month getMonth() {
        return month;
    }

    @JsonProperty("month")
    public void setMonth(Month month) {
        this.month = month;
    }

    @JsonProperty("year")
    public String getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(String year) {
        this.year = year;
    }

    @JsonProperty("designation")
    public Designation getDesignation() {
        return designation;
    }

    @JsonProperty("designation")
    public void setDesignation(Designation designation) {
        this.designation = designation;
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
