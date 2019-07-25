
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
    "amiiboSeries",
    "character",
    "gameSeries",
    "head",
    "image",
    "name",
    "release",
    "tail",
    "type"
})
public class Amiibo {

    @JsonProperty("amiiboSeries")
    private String amiiboSeries;
    @JsonProperty("character")
    private String character;
    @JsonProperty("gameSeries")
    private String gameSeries;
    @JsonProperty("head")
    private String head;
    @JsonProperty("image")
    private String image;
    @JsonProperty("name")
    private String name;
    @JsonProperty("release")
    private Release release;
    @JsonProperty("tail")
    private String tail;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("amiiboSeries")
    public String getAmiiboSeries() {
        return amiiboSeries;
    }

    @JsonProperty("amiiboSeries")
    public void setAmiiboSeries(String amiiboSeries) {
        this.amiiboSeries = amiiboSeries;
    }

    @JsonProperty("character")
    public String getCharacter() {
        return character;
    }

    @JsonProperty("character")
    public void setCharacter(String character) {
        this.character = character;
    }

    @JsonProperty("gameSeries")
    public String getGameSeries() {
        return gameSeries;
    }

    @JsonProperty("gameSeries")
    public void setGameSeries(String gameSeries) {
        this.gameSeries = gameSeries;
    }

    @JsonProperty("head")
    public String getHead() {
        return head;
    }

    @JsonProperty("head")
    public void setHead(String head) {
        this.head = head;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("release")
    public Release getRelease() {
        return release;
    }

    @JsonProperty("release")
    public void setRelease(Release release) {
        this.release = release;
    }

    @JsonProperty("tail")
    public String getTail() {
        return tail;
    }

    @JsonProperty("tail")
    public void setTail(String tail) {
        this.tail = tail;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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
