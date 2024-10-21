package com.nextdoor.api;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.Advertiser;
import com.nextdoor.models.ConversionType;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.util.NextDoorUtil;

import static com.nextdoor.constants.DefaultURLS.DEFAULT_FULL_ADS_API_URL;

public class NextDoorAPIAdvertiser extends NextDoorAPIRequestNode {
    public NextDoorAPIAdvertiser() {

    }

    public NextDoorAPIAdvertiser(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPICreateAdvertiser createAdvertiser() {
        return new NextDoorAPICreateAdvertiser(this.getNextDoorAPIAuth());
    }

    public NextDoorAPIUpdateAdvertiser updateAdvertiser() {
        return new NextDoorAPIUpdateAdvertiser(this.getNextDoorAPIAuth());
    }

    public static class NextDoorAPICreateAdvertiser extends NextDoorAPIRequest<Advertiser> implements NextDoorAPIExecute<Advertiser> {
        public NextDoorAPICreateAdvertiser(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Advertiser.class, nextDoorAPIAuth);

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());
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

    public static class NextDoorAPIUpdateAdvertiser extends NextDoorAPIRequest<Advertiser> implements NextDoorAPIExecute<Advertiser> {
        public NextDoorAPIUpdateAdvertiser(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Advertiser.class, nextDoorAPIAuth);

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());
        }

        public NextDoorAPIUpdateAdvertiser setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDoorAPIUpdateAdvertiser setName(String name) {
            this.setParamInternal("name", name);

            return this;
        }

        public NextDoorAPIUpdateAdvertiser setWebsiteUrl(String websiteUrl) {
            this.setParamInternal("website_url", websiteUrl);

            return this;
        }

        public NextDoorAPIUpdateAdvertiser setUserSetBillingLimit(String userSetBillingLimit) {
            this.setParamInternal("user_set_billing_limit", userSetBillingLimit);

            return this;
        }

        public NextDoorAPIUpdateAdvertiser setCategoryId(String categoryId) {
            this.setParamInternal("category_id", categoryId);

            return this;
        }

        public NextDoorAPIUpdateAdvertiser setAddress(Advertiser.Address address) {
            this.setParamInternal("address", address);

            return this;
        }

        public NextDoorAPIUpdateAdvertiser setBillToPaymentProfileId(String billToPaymentProfileId) {
            this.setParamInternal("bill_to_payment_profile_id", billToPaymentProfileId);

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "advertiser/update";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("advertiser_id"), "advertiser_id");
        }

        @Override
        public Advertiser execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new AdvertiserUpdateException("Can't update advertiser campaign, because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdvertiserUpdateException extends APIRequestException {
            public AdvertiserUpdateException() {
            }

            public AdvertiserUpdateException(String s) {
                super(s);
            }

            public AdvertiserUpdateException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdvertiserUpdateException(Throwable throwable) {
                super(throwable);
            }

            public AdvertiserUpdateException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIAdvertiserCategoriesList extends NextDoorAPIRequest<Advertiser> implements NextDoorAPIExecute<Advertiser> {
        private final String advertiserId;

        public NextDoorAPIAdvertiserCategoriesList(NextDoorAPIAuth nextDoorAPIAuth, String advertiserId) {
            super(Advertiser.class, nextDoorAPIAuth);

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());
            NextDoorUtil.ensureStringNotNull(advertiserId, "advertiserId");
            this.setParamInternal("advertiser_id", advertiserId);
            this.advertiserId = advertiserId;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "advertiser/categories/list";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("advertiser_id"), "advertiser_id");
        }

        @Override
        public Advertiser execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.GET, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new AdvertiserCategoriesListFoundException("Can't find Advertiser categories list with ID" + this.advertiserId + ", because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdvertiserCategoriesListFoundException extends APIRequestException {
            public AdvertiserCategoriesListFoundException() {
            }

            public AdvertiserCategoriesListFoundException(String s) {
                super(s);
            }

            public AdvertiserCategoriesListFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdvertiserCategoriesListFoundException(Throwable throwable) {
                super(throwable);
            }

            public AdvertiserCategoriesListFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}
