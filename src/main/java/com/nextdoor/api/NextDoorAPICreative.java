package com.nextdoor.api;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.AdCreative;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;

import java.util.Collection;

import static com.nextdoor.constants.DefaultURLS.DEFAULT_FULL_ADS_API_URL;

public class NextDoorAPICreative extends NextDoorAPIRequestNode {
    public NextDoorAPICreative() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPICreative(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPICreateCreative createCreative() {
        return new NextDoorAPICreateCreative(this.nextDoorAPIAuth);
    }

    public static class NextDoorAPICreateCreative extends NextDoorAPIRequest<AdCreative> implements NextDoorAPIExecute<AdCreative> {
        public NextDoorAPICreateCreative(NextDoorAPIAuth nextDoorAPIAuth) {
            super(AdCreative.class, nextDoorAPIAuth);

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());
        }

        public NextDoorAPICreateCreative setName(String name) {
            this.setParamInternal("name", name);

            return this;
        }

        public NextDoorAPICreateCreative setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDoorAPICreateCreative setPlacement(String placement) {
            this.setParamInternal("placement", placement);

            return this;
        }

        public NextDoorAPICreateCreative setAdvertiserName(String advertiserName) {
            this.setParamInternal("advertiser_name", advertiserName);

            return this;
        }

        public NextDoorAPICreateCreative setHeadline(String headline) {
            this.setParamInternal("headline", headline);

            return this;
        }

        public NextDoorAPICreateCreative setBodyText(String bodyText) {
            this.setParamInternal("body_text", bodyText);

            return this;
        }

        public NextDoorAPICreateCreative setOfferText(String offerText) {
            this.setParamInternal("offer_text", offerText);

            return this;
        }

        public NextDoorAPICreateCreative setPrice(String price) {
            this.setParamInternal("price", price);

            return this;
        }

        public NextDoorAPICreateCreative setPrice(double price) {
            this.setParamInternal("price", String.valueOf(price));

            return this;
        }

        public NextDoorAPICreateCreative setCTA(String cta) {
            this.setParamInternal("cta", cta);

            return this;
        }

        public NextDoorAPICreateCreative setCanvasImageId(String canvasImageId) {
            this.setParamInternal("canvas_image_id", canvasImageId);

            return this;
        }

        public NextDoorAPICreateCreative setLogoImageId(String logoImageId) {
            this.setParamInternal("logo_image_id", logoImageId);

            return this;
        }

        public NextDoorAPICreateCreative setClickthroughUrl(String clickthroughUrl) {
            this.setParamInternal("clickthrough_url", clickthroughUrl);

            return this;
        }

        public NextDoorAPICreateCreative setImpressionTrackingUr(Collection<String> impressionTrackingUr) {
            this.setParamInternal("impression_tracking_ur", impressionTrackingUr);

            return this;
        }

        public NextDoorAPICreateCreative setClickTrackingUrls(Collection<String> clickTrackingUrls) {
            this.setParamInternal("click_tracking_urls", clickTrackingUrls);

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "creative/create";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public AdCreative execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST);
            } catch (APIRequestException e) {
                throw new AdCreativeCreationException("Cannot create creative because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdCreativeCreationException extends APIRequestException {
            public AdCreativeCreationException() {
            }

            public AdCreativeCreationException(String s) {
                super(s);
            }

            public AdCreativeCreationException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdCreativeCreationException(Throwable throwable) {
                super(throwable);
            }

            public AdCreativeCreationException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}
