package com.nextdoor.api;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.share.NextDoorAPIRequestNode;
import com.nextdoor.share.NextDoorAPIRequest;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.NextDoorUser;

public class NextDoorAPIUser extends NextDoorAPIRequestNode {
    public NextDoorAPIUser() {

    }

    public NextDoorAPIUser(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPIUserInfo getUserInfo() {
        return new NextDoorAPIUserInfo(this);
    }

    public static class NextDoorAPIUserInfo extends NextDoorAPIRequest<NextDoorUser> {
        private final NextDoorAPIUser nextDoorAPIUser;

        public NextDoorAPIUserInfo(NextDoorAPIUser nextDoorAPIUser) {
            super(NextDoorUser.class, nextDoorAPIUser.getNextDoorAPIAuth());

            this.nextDoorAPIUser = nextDoorAPIUser;
        }

        public NextDoorUser get() throws APIRequestException {
            this.addHeader(this.nextDoorAPIUser.getNextDoorAPIAuth().getTokenHeader());

            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new UserGetException("Can't get user info, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + "me";
        }

        @Override
        protected void validateRequiredParams() {

        }

        public static class UserGetException extends APIRequestException {
            public UserGetException() {
            }

            public UserGetException(String s) {
                super(s);
            }

            public UserGetException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public UserGetException(Throwable throwable) {
                super(throwable);
            }

            public UserGetException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}