package com.nextdoor.api;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.Ad;
import com.nextdoor.models.ConversionType;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.util.NextDoorUtil;

import static com.nextdoor.constants.DefaultURLS.DEFAULT_FULL_ADS_API_URL;

public class NextDoorAPIAd extends NextDoorAPIRequestNode {
    public NextDoorAPIAd() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPIAd(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPICreateAd createAd() {
        return new NextDoorAPICreateAd(this.nextDoorAPIAuth);
    }

    public static class NextDoorAPICreateAd extends NextDoorAPIRequest<Ad> implements NextDoorAPIExecute<Ad> {
        public NextDoorAPICreateAd(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Ad.class, nextDoorAPIAuth);

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());
        }

        public NextDoorAPICreateAd setName(String name) {
            this.setParamInternal("name", name);

            return this;
        }

        public NextDoorAPICreateAd setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDoorAPICreateAd setAdGroupId(String adGroupId) {
            this.setParamInternal("ad_group_id", adGroupId);

            return this;
        }

        public NextDoorAPICreateAd setCreativeId(String creativeId) {
            this.setParamInternal("creative_id", creativeId);

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "ad/create";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("name"), "name");
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("advertiser_id"), "advertiser_id");
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("adgroup_id"), "adgroup_id");
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("creative_id"), "creative_id");
        }

        @Override
        public Ad execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new AdCreateException("Can't create advertiser campaign, because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdCreateException extends APIRequestException {
            public AdCreateException() {
            }

            public AdCreateException(String s) {
                super(s);
            }

            public AdCreateException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdCreateException(Throwable throwable) {
                super(throwable);
            }

            public AdCreateException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}
