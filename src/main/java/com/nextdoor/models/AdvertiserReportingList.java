package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdvertiserReportingList extends NextDoorModel implements Serializable {
    @JsonProperty("reports")
    private List<ReportData> reports;

    @JsonProperty("page_info")
    private Pagination pageInfo;

    public AdvertiserReportingList() {
    }

    public AdvertiserReportingList(List<ReportData> reports, Pagination pageInfo) {
        this.reports = reports;
        this.pageInfo = pageInfo;
    }

    public List<ReportData> getReports() {
        return reports;
    }

    public void setReports(List<ReportData> reports) {
        this.reports = reports;
    }

    public Pagination getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ReportData implements Serializable {
        @JsonProperty("cursor")
        private String cursor;

        @JsonProperty("data")
        private AdReporting data;

        public ReportData() {
        }

        public ReportData(String cursor, AdReporting data) {
            this.cursor = cursor;
            this.data = data;
        }

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public AdReporting getData() {
            return data;
        }

        public void setData(AdReporting data) {
            this.data = data;
        }
    }
}