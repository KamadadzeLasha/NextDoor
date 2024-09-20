package com.nextdoor.api;

import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.AdGroup;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;

import java.util.Collection;
import java.util.Date;

public class NextDoorAPIAdGroup extends NextDoorAPIRequestNode {
    public NextDoorAPIAdGroup() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPIAdGroup(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
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
            //TODO: Parse to String
            this.setParamInternal("start_time", startTime.toString());

            return this;
        }

        public NextDoorAPIAdGroupCreate setStartTime(String startTime) {
            this.setParamInternal("start_time", startTime);

            return this;
        }

        public NextDoorAPIAdGroupCreate setEndTime(Date endTime) {
            //TODO: Parse to String
            this.setParamInternal("end_time", endTime.toString());

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

        @Override
        protected String getPath() {
            return "";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public AdGroup execute() throws APIRequestException {
            return null;
        }
    }
}
