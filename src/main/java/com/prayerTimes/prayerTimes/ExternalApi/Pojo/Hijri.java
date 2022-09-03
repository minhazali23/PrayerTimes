
package com.prayerTimes.prayerTimes.ExternalApi.Pojo;

import java.util.HashMap;
import java.util.List;
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
    "designation",
    "holidays"
})
@Generated("jsonschema2pojo")
public class Hijri {

    @JsonProperty("date")
    private String date;
    @JsonProperty("format")
    private String format;
    @JsonProperty("day")
    private String day;
    @JsonProperty("weekday")
    private Weekday__1 weekday;
    @JsonProperty("month")
    private Month__1 month;
    @JsonProperty("year")
    private String year;
    @JsonProperty("designation")
    private Designation__1 designation;
    @JsonProperty("holidays")
    private List<Object> holidays = null;
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
    public Weekday__1 getWeekday() {
        return weekday;
    }

    @JsonProperty("weekday")
    public void setWeekday(Weekday__1 weekday) {
        this.weekday = weekday;
    }

    @JsonProperty("month")
    public Month__1 getMonth() {
        return month;
    }

    @JsonProperty("month")
    public void setMonth(Month__1 month) {
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
    public Designation__1 getDesignation() {
        return designation;
    }

    @JsonProperty("designation")
    public void setDesignation(Designation__1 designation) {
        this.designation = designation;
    }

    @JsonProperty("holidays")
    public List<Object> getHolidays() {
        return holidays;
    }

    @JsonProperty("holidays")
    public void setHolidays(List<Object> holidays) {
        this.holidays = holidays;
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
