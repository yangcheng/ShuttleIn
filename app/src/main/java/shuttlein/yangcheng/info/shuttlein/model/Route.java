package shuttlein.yangcheng.info.shuttlein.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ID",
        "ArrivalsEnabled",
        "DisplayName",
        "CustomerID",
        "DirectionStops",
        "Points",
        "Color",
        "TextColor",
        "ArrivalsShowVehicleNames",
        "IsHeadway",
        "ShowLine",
        "Name",
        "ShortName",
        "RegionIDs",
        "ForwardDirectionName",
        "BackwardDirectionName",
        "NumberOfVehicles",
        "Patterns"
})
public class Route {

    @JsonProperty("ID")
    private Long iD;
    @JsonProperty("ArrivalsEnabled")
    private Boolean arrivalsEnabled;
    @JsonProperty("DisplayName")
    private String displayName;
    @JsonProperty("CustomerID")
    private Long customerID;
    @JsonProperty("DirectionStops")
    private Object directionStops;
    @JsonProperty("Points")
    private Object points;
    @JsonProperty("Color")
    private String color;
    @JsonProperty("TextColor")
    private String textColor;
    @JsonProperty("ArrivalsShowVehicleNames")
    private Boolean arrivalsShowVehicleNames;
    @JsonProperty("IsHeadway")
    private Boolean isHeadway;
    @JsonProperty("ShowLine")
    private Boolean showLine;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("ShortName")
    private String shortName;
    @JsonProperty("RegionIDs")
    private List<Object> regionIDs = new ArrayList<Object>();
    @JsonProperty("ForwardDirectionName")
    private Object forwardDirectionName;
    @JsonProperty("BackwardDirectionName")
    private Object backwardDirectionName;
    @JsonProperty("NumberOfVehicles")
    private Long numberOfVehicles;
    @JsonProperty("Patterns")
    private List<Pattern> patterns = new ArrayList<Pattern>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ID")
    public Long getID() {
        return iD;
    }

    @JsonProperty("ID")
    public void setID(Long iD) {
        this.iD = iD;
    }

    @JsonProperty("ArrivalsEnabled")
    public Boolean getArrivalsEnabled() {
        return arrivalsEnabled;
    }

    @JsonProperty("ArrivalsEnabled")
    public void setArrivalsEnabled(Boolean arrivalsEnabled) {
        this.arrivalsEnabled = arrivalsEnabled;
    }

    @JsonProperty("DisplayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("DisplayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("CustomerID")
    public Long getCustomerID() {
        return customerID;
    }

    @JsonProperty("CustomerID")
    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    @JsonProperty("DirectionStops")
    public Object getDirectionStops() {
        return directionStops;
    }

    @JsonProperty("DirectionStops")
    public void setDirectionStops(Object directionStops) {
        this.directionStops = directionStops;
    }

    @JsonProperty("Points")
    public Object getPoints() {
        return points;
    }

    @JsonProperty("Points")
    public void setPoints(Object points) {
        this.points = points;
    }

    @JsonProperty("Color")
    public String getColor() {
        return color;
    }

    @JsonProperty("Color")
    public void setColor(String color) {
        this.color = color;
    }

    @JsonProperty("TextColor")
    public String getTextColor() {
        return textColor;
    }

    @JsonProperty("TextColor")
    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    @JsonProperty("ArrivalsShowVehicleNames")
    public Boolean getArrivalsShowVehicleNames() {
        return arrivalsShowVehicleNames;
    }

    @JsonProperty("ArrivalsShowVehicleNames")
    public void setArrivalsShowVehicleNames(Boolean arrivalsShowVehicleNames) {
        this.arrivalsShowVehicleNames = arrivalsShowVehicleNames;
    }

    @JsonProperty("IsHeadway")
    public Boolean getIsHeadway() {
        return isHeadway;
    }

    @JsonProperty("IsHeadway")
    public void setIsHeadway(Boolean isHeadway) {
        this.isHeadway = isHeadway;
    }

    @JsonProperty("ShowLine")
    public Boolean getShowLine() {
        return showLine;
    }

    @JsonProperty("ShowLine")
    public void setShowLine(Boolean showLine) {
        this.showLine = showLine;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("ShortName")
    public String getShortName() {
        return shortName;
    }

    @JsonProperty("ShortName")
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @JsonProperty("RegionIDs")
    public List<Object> getRegionIDs() {
        return regionIDs;
    }

    @JsonProperty("RegionIDs")
    public void setRegionIDs(List<Object> regionIDs) {
        this.regionIDs = regionIDs;
    }

    @JsonProperty("ForwardDirectionName")
    public Object getForwardDirectionName() {
        return forwardDirectionName;
    }

    @JsonProperty("ForwardDirectionName")
    public void setForwardDirectionName(Object forwardDirectionName) {
        this.forwardDirectionName = forwardDirectionName;
    }

    @JsonProperty("BackwardDirectionName")
    public Object getBackwardDirectionName() {
        return backwardDirectionName;
    }

    @JsonProperty("BackwardDirectionName")
    public void setBackwardDirectionName(Object backwardDirectionName) {
        this.backwardDirectionName = backwardDirectionName;
    }

    @JsonProperty("NumberOfVehicles")
    public Long getNumberOfVehicles() {
        return numberOfVehicles;
    }

    @JsonProperty("NumberOfVehicles")
    public void setNumberOfVehicles(Long numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
    }

    @JsonProperty("Patterns")
    public List<Pattern> getPatterns() {
        return patterns;
    }

    @JsonProperty("Patterns")
    public void setPatterns(List<Pattern> patterns) {
        this.patterns = patterns;
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
        return displayName;
    }
}