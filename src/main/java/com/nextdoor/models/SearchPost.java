package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonProperty;

abstract class SearchPost {
    @JsonProperty("body")
    private String body;

    @JsonProperty("embed_url")
    private String embedUrl;

    @JsonProperty("has_geo_tag")
    private boolean hasGeoTag;

    @JsonProperty("id")
    private String id;

    @JsonProperty("url")
    private String url;

    @JsonProperty("title")
    private String title;

    public SearchPost() {

    }

    public SearchPost(String body, String embedUrl, boolean hasGeoTag, String id, String url, String title) {
        this.body = body;
        this.embedUrl = embedUrl;
        this.hasGeoTag = hasGeoTag;
        this.id = id;
        this.url = url;
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEmbedUrl() {
        return embedUrl;
    }

    public void setEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
    }

    public boolean isHasGeoTag() {
        return hasGeoTag;
    }

    public void setHasGeoTag(boolean hasGeoTag) {
        this.hasGeoTag = hasGeoTag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "SearchPost{" +
                "body='" + body + '\'' +
                ", embedUrl='" + embedUrl + '\'' +
                ", hasGeoTag=" + hasGeoTag +
                ", id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
