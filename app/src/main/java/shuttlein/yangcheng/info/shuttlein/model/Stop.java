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
        "Image",
        "Latitude",
        "Longitude",
        "Name",
        "RtpiNumber",
        "ShowLabel",
        "ShowStopRtpiNumberLabel",
        "ShowVehicleName"
})
public class Stop {

    @JsonProperty("ID")
    private long iD;
    @JsonProperty("Image")
    private String image;
    @JsonProperty("Latitude")
    private Double latitude;
    @JsonProperty("Longitude")
    private Double longitude;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("RtpiNumber")
    private long rtpiNumber;
    @JsonProperty("ShowLabel")
    private Boolean showLabel;
    @JsonProperty("ShowStopRtpiNumberLabel")
    private Boolean showStopRtpiNumberLabel;
    @JsonProperty("ShowVehicleName")
    private Boolean showVehicleName;
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

    @JsonProperty("Image")
    public String getImage() {
        return image;
    }

    @JsonProperty("Image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("Latitude")
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty("Latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("Longitude")
    public Double getLongitude() {
        return longitude;
    }

    @JsonProperty("Longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("RtpiNumber")
    public long getRtpiNumber() {
        return rtpiNumber;
    }

    @JsonProperty("RtpiNumber")
    public void setRtpiNumber(long rtpiNumber) {
        this.rtpiNumber = rtpiNumber;
    }

    @JsonProperty("ShowLabel")
    public Boolean getShowLabel() {
        return showLabel;
    }

    @JsonProperty("ShowLabel")
    public void setShowLabel(Boolean showLabel) {
        this.showLabel = showLabel;
    }

    @JsonProperty("ShowStopRtpiNumberLabel")
    public Boolean getShowStopRtpiNumberLabel() {
        return showStopRtpiNumberLabel;
    }

    @JsonProperty("ShowStopRtpiNumberLabel")
    public void setShowStopRtpiNumberLabel(Boolean showStopRtpiNumberLabel) {
        this.showStopRtpiNumberLabel = showStopRtpiNumberLabel;
    }

    @JsonProperty("ShowVehicleName")
    public Boolean getShowVehicleName() {
        return showVehicleName;
    }

    @JsonProperty("ShowVehicleName")
    public void setShowVehicleName(Boolean showVehicleName) {
        this.showVehicleName = showVehicleName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return name;
    }
}