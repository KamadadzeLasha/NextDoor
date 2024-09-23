package com.nextdoor.api;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.AdReporting;
import com.nextdoor.models.DimesionGranularity;
import com.nextdoor.models.Metrics;
import com.nextdoor.models.TimeGranularity;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.util.NextDoorUtil;

import java.util.Collection;
import java.util.Date;

import static com.nextdoor.constants.DefaultURLS.DEFAULT_FULL_ADS_API_URL;

public class NextDoorAPIReporting extends NextDoorAPIRequestNode {
    public NextDoorAPIReporting() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPIReporting(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public static class NextDoorAPIReportingCreate extends NextDoorAPIRequest<AdReporting> implements NextDoorAPIExecute<AdReporting> {
        public NextDoorAPIReportingCreate(NextDoorAPIAuth nextDoorAPIAuth) {
            super(AdReporting.class, nextDoorAPIAuth);

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());
        }

        public NextDoorAPIReportingCreate setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDoorAPIReportingCreate setName(String name) {
            this.setParamInternal("name", name);

            return this;
        }

        public NextDoorAPIReportingCreate setRecipientEmails(Collection<String> recipientEmails) {
            this.setParamInternal("recipient_emails", recipientEmails);

            return this;
        }

        public NextDoorAPIReportingCreate setDimensionGranularity(Collection<DimesionGranularity> dimensionGranularity) {
            this.setParamInternal("dimension_granularity", dimensionGranularity);

            return this;
        }

        public NextDoorAPIReportingCreate setTimeGranularity(Collection<TimeGranularity> timeGranularity) {
            this.setParamInternal("time_granularity", timeGranularity);

            return this;
        }

        public NextDoorAPIReportingCreate setMetrics(Collection<Metrics> metrics) {
            this.setParamInternal("metrics", metrics);

            return this;
        }

        public NextDoorAPIReportingCreate setCampaignIds(Collection<String> campaignIds) {
            this.setParamInternal("campaign_ids", campaignIds);

            return this;
        }

        public NextDoorAPIReportingCreate setAdIds(Collection<String> adIds) {
            this.setParamInternal("ad_ids", adIds);

            return this;
        }

        public NextDoorAPIReportingCreate setStartTime(Date startTime) {
            this.setParamInternal("start_time", NextDoorUtil.formatDate(startTime));

            return this;
        }

        public NextDoorAPIReportingCreate setStartTime(String startTime) {
            this.setParamInternal("start_time", startTime);

            return this;
        }

        public NextDoorAPIReportingCreate setEndTime(Date endTime) {
            this.setParamInternal("end_time", NextDoorUtil.formatDate(endTime));

            return this;
        }

        public NextDoorAPIReportingCreate setEndTime(String endTime) {
            this.setParamInternal("end_time", endTime);

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "reporting/create";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public AdReporting execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST);
            } catch (APIRequestException e) {
                throw new AdReportingCreateException("Cannot create creative because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdReportingCreateException extends APIRequestException {
            public AdReportingCreateException() {
            }

            public AdReportingCreateException(String s) {
                super(s);
            }

            public AdReportingCreateException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdReportingCreateException(Throwable throwable) {
                super(throwable);
            }

            public AdReportingCreateException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}
