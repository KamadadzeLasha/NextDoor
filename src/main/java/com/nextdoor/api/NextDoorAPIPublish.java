package com.nextdoor.api;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.Profile;
import com.nextdoor.models.Profiles;
import com.nextdoor.share.NextDoorAPIGet;
import com.nextdoor.share.NextDoorAPIRequest;
import com.nextdoor.share.NextDoorAPIRequestNode;

public class NextDoorAPIPublish extends NextDoorAPIRequestNode {
    public NextDoorAPIPublish() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPIPublish(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPIPublishProfileInfo getProfileInfo() {
        return new NextDoorAPIPublishProfileInfo(this.getNextDoorAPIAuth());
    }

    public static class NextDoorAPIPublishProfileInfo extends NextDoorAPIRequest<Profile> implements NextDoorAPIGet<Profile> {
        public NextDoorAPIPublishProfileInfo(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Profile.class, nextDoorAPIAuth);
        }

        @Override
        public Profile get() throws APIRequestException {
            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());

            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new ProifleGetException("Can't get profile info for: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_EXTERNAL_API_URL + "me";
        }

        @Override
        protected void validateRequiredParams() {

        }

        public Profiles getProfiles() throws APIRequestException {
            return new NextDoorAPIPublishProfilesInfo(this.getNextDoorAPIAuth()).get();
        }

        public static class ProifleGetException extends APIRequestException {
            public ProifleGetException() {
            }

            public ProifleGetException(String s) {
                super(s);
            }

            public ProifleGetException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public ProifleGetException(Throwable throwable) {
                super(throwable);
            }

            public ProifleGetException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }

        public static class NextDoorAPIPublishProfilesInfo extends NextDoorAPIRequest<Profiles> implements NextDoorAPIGet<Profiles> {
            public NextDoorAPIPublishProfilesInfo(NextDoorAPIAuth nextDoorAPIAuth) {
                super(Profiles.class, nextDoorAPIAuth);
            }

            @Override
            protected String getPath() {
                return DefaultURLS.DEFAULT_FULL_EXTERNAL_API_URL + "me/profiles";
            }

            @Override
            protected void validateRequiredParams() {

            }

            @Override
            public Profiles get() throws APIRequestException {
                this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());

                try {
                    return sendHttpRequest(HttpMethod.GET);
                } catch (APIRequestException e) {
                    throw new ProfilesGetException("Can't get profiles list from the API for: " + e.getLocalizedMessage());
                }
            }

            public static class ProfilesGetException extends APIRequestException {
                public ProfilesGetException() {
                }

                public ProfilesGetException(String s) {
                    super(s);
                }

                public ProfilesGetException(String s, Throwable throwable) {
                    super(s, throwable);
                }

                public ProfilesGetException(Throwable throwable) {
                    super(throwable);
                }

                public ProfilesGetException(String s, Throwable throwable, boolean b, boolean b1) {
                    super(s, throwable, b, b1);
                }
            }
        }
    }
}