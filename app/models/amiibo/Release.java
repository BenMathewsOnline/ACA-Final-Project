
package models.amiibo;

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
    "au",
    "eu",
    "jp",
    "na"
})
public class Release {

    @JsonProperty("au")
    private String au;
    @JsonProperty("eu")
    private String eu;
    @JsonProperty("jp")
    private String jp;
    @JsonProperty("na")
    private String na;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("au")
    public String getAu() {
        return au;
    }

    @JsonProperty("au")
    public void setAu(String au) {
        this.au = au;
    }

    @JsonProperty("eu")
    public String getEu() {
        return eu;
    }

    @JsonProperty("eu")
    public void setEu(String eu) {
        this.eu = eu;
    }

    @JsonProperty("jp")
    public String getJp() {
        return jp;
    }

    @JsonProperty("jp")
    public void setJp(String jp) {
        this.jp = jp;
    }

    @JsonProperty("na")
    public String getNa() {
        return na;
    }

    @JsonProperty("na")
    public void setNa(String na) {
        this.na = na;
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
