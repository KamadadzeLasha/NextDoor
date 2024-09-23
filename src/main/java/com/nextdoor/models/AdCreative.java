package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdCreative extends NextDoorModel implements Serializable {
    @JsonProperty("id")
    private String id;

    @JsonProperty("advertiser_id")
    private String advertiserId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("status")
    private String status;

    @JsonProperty("placement")
    private String placement;

    @JsonProperty("advertiser_name")
    private String advertiserName;

    @JsonProperty("headline")
    private String headline;

    @JsonProperty("body_text")
    private String bodyText;

    @JsonProperty("offer_text")
    private String offerText;

    @JsonProperty("price")
    private String price;

    @JsonProperty("cta")
    private String cta;

    @JsonProperty("canvas_image_url")
    private String canvasImageUrl;

    @JsonProperty("logo_image_url")
    private String logoImageUrl;

    @JsonProperty("clickthrough_url")
    private String clickthroughUrl;

    @JsonProperty("impression_tracking_urls")
    private List<String> impressionTrackingUrls;

    @JsonProperty("click_tracking_urls")
    private List<String> clickTrackingUrls;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public AdCreative() {

    }

    public AdCreative(String id, String advertiserId, String name, String status, String placement, String advertiserName, String headline, String bodyText, String offerText, String price, String cta, String canvasImageUrl, String logoImageUrl, String clickthroughUrl, List<String> impressionTrackingUrls, List<String> clickTrackingUrls, String createdAt, String updatedAt) {
        this.id = id;
        this.advertiserId = advertiserId;
        this.name = name;
        this.status = status;
        this.placement = placement;
        this.advertiserName = advertiserName;
        this.headline = headline;
        this.bodyText = bodyText;
        this.offerText = offerText;
        this.price = price;
        this.cta = cta;
        this.canvasImageUrl = canvasImageUrl;
        this.logoImageUrl = logoImageUrl;
        this.clickthroughUrl = clickthroughUrl;
        this.impressionTrackingUrls = impressionTrackingUrls;
        this.clickTrackingUrls = clickTrackingUrls;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    public String getAdvertiserName() {
        return advertiserName;
    }

    public void setAdvertiserName(String advertiserName) {
        this.advertiserName = advertiserName;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getBodyText() {
        return bodyText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

    public String getOfferText() {
        return offerText;
    }

    public void setOfferText(String offerText) {
        this.offerText = offerText;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCta() {
        return cta;
    }

    public void setCta(String cta) {
        this.cta = cta;
    }

    public String getCanvasImageUrl() {
        return canvasImageUrl;
    }

    public void setCanvasImageUrl(String canvasImageUrl) {
        this.canvasImageUrl = canvasImageUrl;
    }

    public String getLogoImageUrl() {
        return logoImageUrl;
    }

    public void setLogoImageUrl(String logoImageUrl) {
        this.logoImageUrl = logoImageUrl;
    }

    public String getClickthroughUrl() {
        return clickthroughUrl;
    }

    public void setClickthroughUrl(String clickthroughUrl) {
        this.clickthroughUrl = clickthroughUrl;
    }

    public List<String> getImpressionTrackingUrls() {
        return impressionTrackingUrls;
    }

    public void setImpressionTrackingUrls(List<String> impressionTrackingUrls) {
        this.impressionTrackingUrls = impressionTrackingUrls;
    }

    public List<String> getClickTrackingUrls() {
        return clickTrackingUrls;
    }

    public void setClickTrackingUrls(List<String> clickTrackingUrls) {
        this.clickTrackingUrls = clickTrackingUrls;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "AdCreative{" +
                "id='" + id + '\'' +
                ", advertiserId='" + advertiserId + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", placement='" + placement + '\'' +
                ", advertiserName='" + advertiserName + '\'' +
                ", headline='" + headline + '\'' +
                ", bodyText='" + bodyText + '\'' +
                ", offerText='" + offerText + '\'' +
                ", price='" + price + '\'' +
                ", cta='" + cta + '\'' +
                ", canvasImageUrl='" + canvasImageUrl + '\'' +
                ", logoImageUrl='" + logoImageUrl + '\'' +
                ", clickthroughUrl='" + clickthroughUrl + '\'' +
                ", impressionTrackingUrls=" + impressionTrackingUrls +
                ", clickTrackingUrls=" + clickTrackingUrls +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}