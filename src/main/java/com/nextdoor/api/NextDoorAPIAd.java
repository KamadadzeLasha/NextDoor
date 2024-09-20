package com.nextdoor.api;

import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.Ad;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;

public class NextDoorAPIAd extends NextDoorAPIRequestNode {
    public NextDoorAPIAd() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPIAd(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public static class NextDoorAPICreateAd extends NextDoorAPIRequest<Ad> implements NextDoorAPIExecute<Ad> {
        public NextDoorAPICreateAd(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Ad.class, nextDoorAPIAuth);
        }

        @Override
        protected String getPath() {
            return "";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public Ad execute() throws APIRequestException {
            return null;
        }
    }
}
