package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdvertiserReportingScheduledList extends NextDoorModel implements Serializable {
    @JsonProperty("scheduled_reports")
    private List<ScheduledReport> scheduledReports;

    @JsonProperty("page_info")
    private Pagination pageInfo;

    public AdvertiserReportingScheduledList() {
    }

    public AdvertiserReportingScheduledList(List<ScheduledReport> scheduledReports, Pagination pageInfo) {
        this.scheduledReports = scheduledReports;
        this.pageInfo = pageInfo;
    }

    public List<ScheduledReport> getScheduledReports() {
        return scheduledReports;
    }

    public void setScheduledReports(List<ScheduledReport> scheduledReports) {
        this.scheduledReports = scheduledReports;
    }

    public Pagination getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ScheduledReport implements Serializable {
        @JsonProperty("cursor")
        private String cursor;

        @JsonProperty("data")
        private ScheduledReportData data;

        public ScheduledReport() {
        }

        public ScheduledReport(String cursor, ScheduledReportData data) {
            this.cursor = cursor;
            this.data = data;
        }

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public ScheduledReportData getData() {
            return data;
        }

        public void setData(ScheduledReportData data) {
            this.data = data;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ScheduledReportData implements Serializable {
        @JsonProperty("id")
        private String id;

        @JsonProperty("advertiser_id")
        private String advertiserId;

        @JsonProperty("name")
        private String name;

        @JsonProperty("schedule")
        private String schedule;

        @JsonProperty("timezone")
        private String timezone;

        @JsonProperty("recipient_emails")
        private List<String> recipientEmails;

        @JsonProperty("dimension_granularity")
        private List<String> dimensionGranularity;

        @JsonProperty("time_granularity")
        private List<String> timeGranularity;

        @JsonProperty("metrics")
        private List<String> metrics;

        @JsonProperty("campaign_ids")
        private List<String> campaignIds;

        @JsonProperty("adgroup_ids")
        private List<String> adGroupIds;

        @JsonProperty("ad_ids")
        private List<String> adIds;

        @JsonProperty("is_archived")
        private boolean isArchived;

        public ScheduledReportData() {

        }

        public ScheduledReportData(String id, String advertiserId, String name, String schedule, String timezone,
                                   List<String> recipientEmails, List<String> dimensionGranularity,
                                   List<String> timeGranularity, List<String> metrics, List<String> campaignIds,
                                   List<String> adGroupIds, List<String> adIds, boolean isArchived) {
            this.id = id;
            this.advertiserId = advertiserId;
            this.name = name;
            this.schedule = schedule;
            this.timezone = timezone;
            this.recipientEmails = recipientEmails;
            this.dimensionGranularity = dimensionGranularity;
            this.timeGranularity = timeGranularity;
            this.metrics = metrics;
            this.campaignIds = campaignIds;
            this.adGroupIds = adGroupIds;
            this.adIds = adIds;
            this.isArchived = isArchived;
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

        public String getSchedule() {
            return schedule;
        }

        public void setSchedule(String schedule) {
            this.schedule = schedule;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public List<String> getRecipientEmails() {
            return recipientEmails;
        }

        public void setRecipientEmails(List<String> recipientEmails) {
            this.recipientEmails = recipientEmails;
        }

        public List<String> getDimensionGranularity() {
            return dimensionGranularity;
        }

        public void setDimensionGranularity(List<String> dimensionGranularity) {
            this.dimensionGranularity = dimensionGranularity;
        }

        public List<String> getTimeGranularity() {
            return timeGranularity;
        }

        public void setTimeGranularity(List<String> timeGranularity) {
            this.timeGranularity = timeGranularity;
        }

        public List<String> getMetrics() {
            return metrics;
        }

        public void setMetrics(List<String> metrics) {
            this.metrics = metrics;
        }

        public List<String> getCampaignIds() {
            return campaignIds;
        }

        public void setCampaignIds(List<String> campaignIds) {
            this.campaignIds = campaignIds;
        }

        public List<String> getAdGroupIds() {
            return adGroupIds;
        }

        public void setAdGroupIds(List<String> adGroupIds) {
            this.adGroupIds = adGroupIds;
        }

        public List<String> getAdIds() {
            return adIds;
        }

        public void setAdIds(List<String> adIds) {
            this.adIds = adIds;
        }

        public boolean isArchived() {
            return isArchived;
        }

        public void setArchived(boolean archived) {
            isArchived = archived;
        }
    }
}