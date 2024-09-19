package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {
    @JsonProperty("agencyInfo")
    private Map<String, Object> agencyInfo;

    @JsonProperty("cityUrl")
    private String cityUrl;

    @JsonProperty("name")
    private String name;

    @JsonProperty("neighborhoodName")
    private String neighborhoodName;

    @JsonProperty("neighborhoodUrl")
    private String neighborhoodUrl;

    @JsonProperty("type")
    private String type;

    public Author() {

    }

    public Author(Map<String, Object> agencyInfo, String cityUrl, String name, String neighborhoodName, String neighborhoodUrl, String type) {
        this.agencyInfo = agencyInfo;
        this.cityUrl = cityUrl;
        this.name = name;
        this.neighborhoodName = neighborhoodName;
        this.neighborhoodUrl = neighborhoodUrl;
        this.type = type;
    }

    public Map<String, Object> getAgencyInfo() {
        return agencyInfo;
    }

    public void setAgencyInfo(Map<String, Object> agencyInfo) {
        this.agencyInfo = agencyInfo;
    }

    public String getCityUrl() {
        return cityUrl;
    }

    public void setCityUrl(String cityUrl) {
        this.cityUrl = cityUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNeighborhoodName() {
        return neighborhoodName;
    }

    public void setNeighborhoodName(String neighborhoodName) {
        this.neighborhoodName = neighborhoodName;
    }

    public String getNeighborhoodUrl() {
        return neighborhoodUrl;
    }

    public void setNeighborhoodUrl(String neighborhoodUrl) {
        this.neighborhoodUrl = neighborhoodUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Author{" +
                "agencyInfo=" + agencyInfo +
                ", cityUrl='" + cityUrl + '\'' +
                ", name='" + name + '\'' +
                ", neighborhoodName='" + neighborhoodName + '\'' +
                ", neighborhoodUrl='" + neighborhoodUrl + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}