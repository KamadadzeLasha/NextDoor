package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdGroup extends NextDoorModel implements Serializable {

    @JsonProperty("id")
    private String id;

    @JsonProperty("advertiser_id")
    private String advertiserId;

    @JsonProperty("campaign_id")
    private String campaignId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("status")
    private String status;

    @JsonProperty("user_status")
    private String userStatus;

    @JsonProperty("placements")
    private List<String> placements;

    @JsonProperty("bid")
    private Bid bid;

    @JsonProperty("budget")
    private Budget budget;

    @JsonProperty("start_time")
    private String startTime;

    @JsonProperty("end_time")
    private String endTime;

    @JsonProperty("frequency_caps")
    private List<FrequencyCap> frequencyCaps;

    @JsonProperty("targeting")
    private Targeting targeting;

    @JsonProperty("custom_audience_ids")
    private List<String> customAudienceIds;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public AdGroup() {

    }

    public AdGroup(String id, String advertiserId, String campaignId, String name, String status, String userStatus, List<String> placements, Bid bid, Budget budget, String startTime, String endTime, List<FrequencyCap> frequencyCaps, Targeting targeting, List<String> customAudienceIds, String createdAt, String updatedAt) {
        this.id = id;
        this.advertiserId = advertiserId;
        this.campaignId = campaignId;
        this.name = name;
        this.status = status;
        this.userStatus = userStatus;
        this.placements = placements;
        this.bid = bid;
        this.budget = budget;
        this.startTime = startTime;
        this.endTime = endTime;
        this.frequencyCaps = frequencyCaps;
        this.targeting = targeting;
        this.customAudienceIds = customAudienceIds;
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

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
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

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public List<String> getPlacements() {
        return placements;
    }

    public void setPlacements(List<String> placements) {
        this.placements = placements;
    }

    public Bid getBid() {
        return bid;
    }

    public void setBid(Bid bid) {
        this.bid = bid;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<FrequencyCap> getFrequencyCaps() {
        return frequencyCaps;
    }

    public void setFrequencyCaps(List<FrequencyCap> frequencyCaps) {
        this.frequencyCaps = frequencyCaps;
    }

    public Targeting getTargeting() {
        return targeting;
    }

    public void setTargeting(Targeting targeting) {
        this.targeting = targeting;
    }

    public List<String> getCustomAudienceIds() {
        return customAudienceIds;
    }

    public void setCustomAudienceIds(List<String> customAudienceIds) {
        this.customAudienceIds = customAudienceIds;
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
        return "AdGroup{" +
                "id='" + id + '\'' +
                ", advertiserId='" + advertiserId + '\'' +
                ", campaignId='" + campaignId + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", placements=" + placements +
                ", bid=" + bid +
                ", budget=" + budget +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", frequencyCaps=" + frequencyCaps +
                ", targeting=" + targeting +
                ", customAudienceIds=" + customAudienceIds +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Bid {
        @JsonProperty("amount")
        private String amount;

        @JsonProperty("pricing_type")
        private String pricingType;

        public Bid() {

        }

        public Bid(String amount, String pricingType) {
            this.amount = amount;
            this.pricingType = pricingType;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getPricingType() {
            return pricingType;
        }

        public void setPricingType(String pricingType) {
            this.pricingType = pricingType;
        }

        public BidBuilder builder() {
            return new BidBuilder();
        }

        @Override
        public String toString() {
            return "Bid{" +
                    "amount='" + amount + '\'' +
                    ", pricingType='" + pricingType + '\'' +
                    '}';
        }

        public static class BidBuilder {
            private final Bid bid;

            public BidBuilder() {
                this.bid = new Bid();
            }

            public BidBuilder amount(String amount) {
                this.bid.amount = amount;

                return this;
            }

            public BidBuilder pricingType(String pricingType) {
                this.bid.pricingType = pricingType;

                return this;
            }

            public Bid create() {
                return this.bid;
            }
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Budget {
        @JsonProperty("amount")
        private String amount;

        @JsonProperty("budget_type")
        private String budgetType;

        public Budget() {

        }

        public Budget(String amount, String budgetType) {
            this.amount = amount;
            this.budgetType = budgetType;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getBudgetType() {
            return budgetType;
        }

        public void setBudgetType(String budgetType) {
            this.budgetType = budgetType;
        }

        public BudgetBuilder builder() {
            return new BudgetBuilder();
        }

        @Override
        public String toString() {
            return "Budget{" +
                    "amount='" + amount + '\'' +
                    ", budgetType='" + budgetType + '\'' +
                    '}';
        }

        public static class BudgetBuilder {
            private final Budget budget;

            public BudgetBuilder() {
                this.budget = new Budget();
            }

            public BudgetBuilder amount(String amount) {
                this.budget.amount = amount;

                return this;
            }

            public BudgetBuilder budgetType(String budgetType) {
                this.budget.budgetType = budgetType;

                return this;
            }

            public Budget create() {
                return this.budget;
            }
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FrequencyCap {
        @JsonProperty("max_impressions")
        private int maxImpressions;

        @JsonProperty("num_timeunits")
        private int numTimeunits;

        @JsonProperty("timeunit")
        private TimeUnit timeunit;

        public FrequencyCap() {

        }

        public FrequencyCap(int maxImpressions, int numTimeunits, TimeUnit timeunit) {
            this.maxImpressions = maxImpressions;
            this.numTimeunits = numTimeunits;
            this.timeunit = timeunit;
        }

        public int getMaxImpressions() {
            return maxImpressions;
        }

        public void setMaxImpressions(int maxImpressions) {
            this.maxImpressions = maxImpressions;
        }

        public int getNumTimeunits() {
            return numTimeunits;
        }

        public void setNumTimeunits(int numTimeunits) {
            this.numTimeunits = numTimeunits;
        }

        public TimeUnit getTimeunit() {
            return timeunit;
        }

        public void setTimeunit(TimeUnit timeunit) {
            this.timeunit = timeunit;
        }

        public FrequencyCapBuilder builder() {
            return new FrequencyCapBuilder();
        }

        @Override
        public String toString() {
            return "FrequencyCap{" +
                    "maxImpressions=" + maxImpressions +
                    ", numTimeunits=" + numTimeunits +
                    ", timeunit='" + timeunit + '\'' +
                    '}';
        }

        public enum TimeUnit {
            MINUTE,
            MINUTES,
            HOUR,
            HOURS,
            DAY,
            DAYS,
            WEEK,
            WEEKS,
            MONTH,
            MONTHS
        }

        public static class FrequencyCapBuilder {
            private final FrequencyCap frequencyCap;

            public FrequencyCapBuilder() {
                this.frequencyCap = new FrequencyCap();
            }

            public FrequencyCapBuilder maxImpressions(int maxImpressions) {
                this.frequencyCap.maxImpressions = maxImpressions;

                return this;
            }

            public FrequencyCapBuilder numTimeunits(int numTimeunits) {
                this.frequencyCap.numTimeunits = numTimeunits;

                return this;
            }

            public FrequencyCapBuilder timeunit(TimeUnit timeunit) {
                this.frequencyCap.timeunit = timeunit;

                return this;
            }

            public FrequencyCap create() {
                return this.frequencyCap;
            }
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Targeting {
        @JsonProperty("included_location_targeting_ids")
        private List<String> includedLocationTargetingIds;

        @JsonProperty("excluded_location_targeting_ids")
        private List<String> excludedLocationTargetingIds;

        @JsonProperty("audience_targeting_ids")
        private List<String> audienceTargetingIds;

        @JsonProperty("time_of_day")
        private TimeOfDay timeOfDay;

        public Targeting() {

        }

        public Targeting(List<String> includedLocationTargetingIds, List<String> excludedLocationTargetingIds, List<String> audienceTargetingIds, TimeOfDay timeOfDay) {
            this.includedLocationTargetingIds = includedLocationTargetingIds;
            this.excludedLocationTargetingIds = excludedLocationTargetingIds;
            this.audienceTargetingIds = audienceTargetingIds;
            this.timeOfDay = timeOfDay;
        }

        public List<String> getIncludedLocationTargetingIds() {
            return includedLocationTargetingIds;
        }

        public void setIncludedLocationTargetingIds(List<String> includedLocationTargetingIds) {
            this.includedLocationTargetingIds = includedLocationTargetingIds;
        }

        public List<String> getExcludedLocationTargetingIds() {
            return excludedLocationTargetingIds;
        }

        public void setExcludedLocationTargetingIds(List<String> excludedLocationTargetingIds) {
            this.excludedLocationTargetingIds = excludedLocationTargetingIds;
        }

        public List<String> getAudienceTargetingIds() {
            return audienceTargetingIds;
        }

        public void setAudienceTargetingIds(List<String> audienceTargetingIds) {
            this.audienceTargetingIds = audienceTargetingIds;
        }

        public TimeOfDay getTimeOfDay() {
            return timeOfDay;
        }

        public void setTimeOfDay(TimeOfDay timeOfDay) {
            this.timeOfDay = timeOfDay;
        }

        public TargetingBuilder builder() {
            return new TargetingBuilder();
        }

        @Override
        public String toString() {
            return "Targeting{" +
                    "includedLocationTargetingIds=" + includedLocationTargetingIds +
                    ", excludedLocationTargetingIds=" + excludedLocationTargetingIds +
                    ", audienceTargetingIds=" + audienceTargetingIds +
                    ", timeOfDay=" + timeOfDay +
                    '}';
        }

        public static class TargetingBuilder {
            private final Targeting targeting;

            public TargetingBuilder() {
                this.targeting = new Targeting();
            }

            public TargetingBuilder includedLocationTargetingIds(List<String> includedLocationTargetingIds) {
                this.targeting.includedLocationTargetingIds = includedLocationTargetingIds;

                return this;
            }

            public TargetingBuilder excludedLocationTargetingIds(List<String> excludedLocationTargetingIds) {
                this.targeting.excludedLocationTargetingIds = excludedLocationTargetingIds;

                return this;
            }

            public TargetingBuilder audienceTargetingIds(List<String> audienceTargetingIds) {
                this.targeting.audienceTargetingIds = audienceTargetingIds;

                return this;
            }

            public TargetingBuilder timeOfDay(TimeOfDay timeOfDay) {
                this.targeting.timeOfDay = timeOfDay;

                return this;
            }

            public Targeting create() {
                return this.targeting;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class TimeOfDay {
            @JsonProperty("included")
            private List<TimeSlot> included;

            @JsonProperty("excluded")
            private List<TimeSlot> excluded;

            public TimeOfDay() {

            }

            public TimeOfDay(List<TimeSlot> included, List<TimeSlot> excluded) {
                this.included = included;
                this.excluded = excluded;
            }

            public List<TimeSlot> getIncluded() {
                return included;
            }

            public void setIncluded(List<TimeSlot> included) {
                this.included = included;
            }

            public List<TimeSlot> getExcluded() {
                return excluded;
            }

            public void setExcluded(List<TimeSlot> excluded) {
                this.excluded = excluded;
            }

            public TimeOfDayBuilder builder() {
                return new TimeOfDayBuilder();
            }

            @Override
            public String toString() {
                return "TimeOfDay{" +
                        "included=" + included +
                        ", excluded=" + excluded +
                        '}';
            }

            public static class TimeOfDayBuilder {
                private final TimeOfDay timeOfDay;

                public TimeOfDayBuilder() {
                    this.timeOfDay = new TimeOfDay();
                }

                public TimeOfDayBuilder setIncluded(List<TimeSlot> included) {
                    this.timeOfDay.included = included;

                    return this;
                }

                public TimeOfDayBuilder setExcluded(List<TimeSlot> excluded) {
                    this.timeOfDay.excluded = excluded;

                    return this;
                }

                public TimeOfDay create() {
                    return this.timeOfDay;
                }
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class TimeSlot {
                @JsonProperty("days")
                private List<String> days;

                @JsonProperty("time")
                private TimeRange time;

                public TimeSlot() {

                }

                public TimeSlot(List<String> days, TimeRange time) {
                    this.days = days;
                    this.time = time;
                }

                public List<String> getDays() {
                    return days;
                }

                public void setDays(List<String> days) {
                    this.days = days;
                }

                public TimeRange getTime() {
                    return time;
                }

                public void setTime(TimeRange time) {
                    this.time = time;
                }

                public TimeSlotBuilder builder() {
                    return new TimeSlotBuilder();
                }

                @Override
                public String toString() {
                    return "TimeSlot{" +
                            "days=" + days +
                            ", time=" + time +
                            '}';
                }

                public static class TimeSlotBuilder {
                    private final TimeSlot timeSlot;

                    public TimeSlotBuilder() {
                        this.timeSlot = new TimeSlot();
                    }

                    public TimeSlotBuilder setDays(List<String> days) {
                        this.timeSlot.days = days;

                        return this;
                    }

                    public TimeSlotBuilder setTime(TimeRange time) {
                        this.timeSlot.time = time;

                        return this;
                    }

                    public TimeSlot create() {
                        return this.timeSlot;
                    }
                }

                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class TimeRange {
                    @JsonProperty("start_time")
                    private String startTime;

                    @JsonProperty("end_time")
                    private String endTime;

                    public TimeRange() {

                    }

                    public TimeRange(String startTime, String endTime) {
                        this.startTime = startTime;
                        this.endTime = endTime;
                    }

                    public String getStartTime() {
                        return startTime;
                    }

                    public void setStartTime(String startTime) {
                        this.startTime = startTime;
                    }

                    public String getEndTime() {
                        return endTime;
                    }

                    public void setEndTime(String endTime) {
                        this.endTime = endTime;
                    }

                    public TimeRangeBuilder builder() {
                        return new TimeRangeBuilder();
                    }

                    @Override
                    public String toString() {
                        return "TimeRange{" +
                                "startTime='" + startTime + '\'' +
                                ", endTime='" + endTime + '\'' +
                                '}';
                    }

                    public static class TimeRangeBuilder {
                        private final TimeRange timeRange;

                        public TimeRangeBuilder() {
                            this.timeRange = new TimeRange();
                        }

                        public TimeRangeBuilder setStartTime(String startTime) {
                            this.timeRange.startTime = startTime;

                            return this;
                        }

                        public TimeRangeBuilder setEndTime(String endTime) {
                            this.timeRange.endTime = endTime;

                            return this;
                        }

                        public TimeRange create() {
                            return this.timeRange;
                        }
                    }
                }
            }
        }
    }
}
