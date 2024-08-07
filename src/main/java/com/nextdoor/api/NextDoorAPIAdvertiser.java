package com.nextdoor.api;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.Advertiser;
import com.nextdoor.models.ConversionType;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.util.NextDoorUtil;

public class NextDoorAPIAdvertiser extends NextDoorAPIRequestNode {
    public NextDoorAPIAdvertiser() {

    }

    public NextDoorAPIAdvertiser(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPICreateAdvertiser createAdvertiser() {
        return new NextDoorAPICreateAdvertiser(this.getNextDoorAPIAuth());
    }

    public static class NextDoorAPICreateAdvertiser extends NextDoorAPIRequest<Advertiser> implements NextDoorAPIExecute<Advertiser> {
        public NextDoorAPICreateAdvertiser(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Advertiser.class, nextDoorAPIAuth);
        }

        public NextDoorAPICreateAdvertiser setName(String name) {
            this.setParamInternal("name", name);

            return this;
        }

        public NextDoorAPICreateAdvertiser setWebsiteUrl(String websiteUrl) {
            this.setParamInternal("website_url", websiteUrl);

            return this;
        }

        public NextDoorAPICreateAdvertiser setCategoryId(String categoryId) {
            this.setParamInternal("category_id", categoryId);

            return this;
        }

        @Override
        public Advertiser execute() throws APIRequestException {
            validateRequiredParams();

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());

            try {
                return sendHttpRequest(HttpMethod.POST, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new AdvertiserCreationException("Can't create advertiser campaign, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + "advertiser/create";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("name"), "name");
        }

        public static class AdvertiserCreationException extends APIRequestException {
            public AdvertiserCreationException() {
            }

            public AdvertiserCreationException(String s) {
                super(s);
            }

            public AdvertiserCreationException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdvertiserCreationException(Throwable throwable) {
                super(throwable);
            }

            public AdvertiserCreationException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}
