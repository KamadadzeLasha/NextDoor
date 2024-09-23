package com.nextdoor.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.AdGroup;
import com.nextdoor.models.ConversionType;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.util.NextDoorUtil;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import static com.nextdoor.constants.DefaultURLS.DEFAULT_FULL_ADS_API_URL;

public class NextDoorAPIAdGroup extends NextDoorAPIRequestNode {
    public NextDoorAPIAdGroup() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPIAdGroup(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPIAdGroupCreate createAdGroup() {
        return new NextDoorAPIAdGroupCreate(this.nextDoorAPIAuth);
    }

    public NextDoorAPIAdGroupUpdate updateAdGroup() {
        return new NextDoorAPIAdGroupUpdate(this.nextDoorAPIAuth);
    }

    public static class NextDoorAPIAdGroupCreate extends NextDoorAPIRequest<AdGroup> implements NextDoorAPIExecute<AdGroup> {
        public NextDoorAPIAdGroupCreate(NextDoorAPIAuth nextDoorAPIAuth) {
            super(AdGroup.class, nextDoorAPIAuth);

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());
        }

        public NextDoorAPIAdGroupCreate setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDoorAPIAdGroupCreate setCampaignId(String campaignId) {
            this.setParamInternal("campaign_id", campaignId);

            return this;
        }

        public NextDoorAPIAdGroupCreate setName(String name) {
            this.setParamInternal("name", name);

            return this;
        }

        public NextDoorAPIAdGroupCreate setPlacements(Collection<String> placements) {
            this.setParamInternal("placements", placements);

            return this;
        }

        public NextDoorAPIAdGroupCreate setBid(AdGroup.Bid bid) {
            this.setParamInternal("bid", bid);

            return this;
        }

        public NextDoorAPIAdGroupCreate setStartTime(Date startTime) {
            this.setParamInternal("start_time", NextDoorUtil.formatDate(startTime));

            return this;
        }

        public NextDoorAPIAdGroupCreate setStartTime(String startTime) {
            this.setParamInternal("start_time", startTime);

            return this;
        }

        public NextDoorAPIAdGroupCreate setEndTime(Date endTime) {
            this.setParamInternal("end_time", NextDoorUtil.formatDate(endTime));

            return this;
        }

        public NextDoorAPIAdGroupCreate setEndTime(String endTime) {
            this.setParamInternal("end_time", endTime);

            return this;
        }

        public NextDoorAPIAdGroupCreate setFrequencyCaps(AdGroup.FrequencyCap frequencyCap) {
            this.setParamInternal("frequency_cap", frequencyCap);

            return this;
        }

        public NextDoorAPIAdGroupCreate setTargeting(AdGroup.Targeting targeting) {
            this.setParamInternal("targeting", targeting);

            return this;
        }

        public NextDoorAPIAdGroupCreate setCustomAudienceTargeting(CustomAudienceTargeting customAudienceTargeting) {
            this.setParamInternal("custom_audience_targeting", customAudienceTargeting);

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "adgroup/create";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("advertiser_id"), "advertiser_id");
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("campaign_id"), "campaign_id");
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("name"), "name");

            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("placements"), "placements");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("bid"), "bid");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("budget"), "budget");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("start_time"), "start_time");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("end_time"), "end_time");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("frequency_caps"), "frequency_caps");
        }

        @Override
        public AdGroup execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new AdGroupCreateException("Can't create advertiser campaign, because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdGroupCreateException extends APIRequestException {
            public AdGroupCreateException() {
            }

            public AdGroupCreateException(String s) {
                super(s);
            }

            public AdGroupCreateException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdGroupCreateException(Throwable throwable) {
                super(throwable);
            }

            public AdGroupCreateException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }

        public static class CustomAudienceTargeting {
            @JsonProperty("include")
            private List<String> include;

            @JsonProperty("exclude")
            private List<String> exclude;

            public CustomAudienceTargeting() {

            }

            public CustomAudienceTargeting(List<String> include, List<String> exclude) {
                this.include = include;
                this.exclude = exclude;
            }

            public List<String> getInclude() {
                return include;
            }

            public void setInclude(List<String> include) {
                this.include = include;
            }

            public List<String> getExclude() {
                return exclude;
            }

            public void setExclude(List<String> exclude) {
                this.exclude = exclude;
            }

            @Override
            public String toString() {
                return "CustomAudienceTargeting{" +
                        "include=" + include +
                        ", exclude=" + exclude +
                        '}';
            }
        }
    }

    public static class NextDoorAPIAdGroupUpdate extends NextDoorAPIRequest<AdGroup> implements NextDoorAPIExecute<AdGroup> {
        public NextDoorAPIAdGroupUpdate(NextDoorAPIAuth nextDoorAPIAuth) {
            super(AdGroup.class, nextDoorAPIAuth);

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());
        }

        public NextDoorAPIAdGroupUpdate setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDoorAPIAdGroupUpdate setCampaignId(String campaignId) {
            this.setParamInternal("campaign_id", campaignId);

            return this;
        }

        public NextDoorAPIAdGroupUpdate setName(String name) {
            this.setParamInternal("name", name);

            return this;
        }

        public NextDoorAPIAdGroupUpdate setPlacements(Collection<String> placements) {
            this.setParamInternal("placements", placements);

            return this;
        }

        public NextDoorAPIAdGroupUpdate setBid(AdGroup.Bid bid) {
            this.setParamInternal("bid", bid);

            return this;
        }

        public NextDoorAPIAdGroupUpdate setBudget(Double budget) {
            this.setParamInternal("budget", budget);

            return this;
        }

        public NextDoorAPIAdGroupUpdate setStartTime(Date startTime) {
            this.setParamInternal("start_time", NextDoorUtil.formatDate(startTime));

            return this;
        }

        public NextDoorAPIAdGroupUpdate setStartTime(String startTime) {
            this.setParamInternal("start_time", startTime);

            return this;
        }

        public NextDoorAPIAdGroupUpdate setEndTime(Date endTime) {
            this.setParamInternal("end_time", NextDoorUtil.formatDate(endTime));

            return this;
        }

        public NextDoorAPIAdGroupUpdate setEndTime(String endTime) {
            this.setParamInternal("end_time", endTime);

            return this;
        }

        public NextDoorAPIAdGroupUpdate setFrequencyCaps(AdGroup.FrequencyCap frequencyCap) {
            this.setParamInternal("frequency_cap", frequencyCap);

            return this;
        }

        public NextDoorAPIAdGroupUpdate setTargeting(AdGroup.Targeting targeting) {
            this.setParamInternal("targeting", targeting);

            return this;
        }

        public NextDoorAPIAdGroupUpdate setCustomAudienceIds(Collection<String> customAudienceIds) {
            this.setParamInternal("custom_audience_ids", customAudienceIds);

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "adgroup/update";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public AdGroup execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new NextDoorAPIAdGroupCreate.AdGroupCreateException("Can't create advertiser campaign, because of: " + e.getLocalizedMessage());
            }
        }
    }
}
