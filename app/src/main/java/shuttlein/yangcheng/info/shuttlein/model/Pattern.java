package shuttlein.yangcheng.info.shuttlein.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ID",
        "Name",
        "Direction",
        "Directionality"
})
public class Pattern {

    @JsonProperty("ID")
    private long iD;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Direction")
    private String direction;
    @JsonProperty("Directionality")
    private String directionality;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ID")
    public long getID() {
        return iD;
    }

    @JsonProperty("ID")
    public void setID(long iD) {
        this.iD = iD;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Direction")
    public String getDirection() {
        return direction;
    }

    @JsonProperty("Direction")
    public void setDirection(String direction) {
        this.direction = direction;
    }

    @JsonProperty("Directionality")
    public String getDirectionality() {
        return directionality;
    }

    @JsonProperty("Directionality")
    public void setDirectionality(String directionality) {
        this.directionality = directionality;
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