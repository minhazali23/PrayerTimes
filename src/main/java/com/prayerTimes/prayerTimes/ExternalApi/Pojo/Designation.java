
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
    "abbreviated",
    "expanded"
})
@Generated("jsonschema2pojo")
public class Designation {

    @JsonProperty("abbreviated")
    private String abbreviated;
    @JsonProperty("expanded")
    private String expanded;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("abbreviated")
    public String getAbbreviated() {
        return abbreviated;
    }

    @JsonProperty("abbreviated")
    public void setAbbreviated(String abbreviated) {
        this.abbreviated = abbreviated;
    }

    @JsonProperty("expanded")
    public String getExpanded() {
        return expanded;
    }

    @JsonProperty("expanded")
    public void setExpanded(String expanded) {
        this.expanded = expanded;
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
