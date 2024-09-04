package com.nextdoor.api;

import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.*;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;

//TODO: Implementation to all classes!
public class NextDoorAPISearch extends NextDoorAPIRequestNode {
    public NextDoorAPISearch() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPISearch(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public static class NextDoorAPISearchPosts extends NextDoorAPIRequest<SearchPosts> implements NextDoorAPIExecute<SearchPosts> {
        public NextDoorAPISearchPosts(NextDoorAPIAuth nextDoorAPIAuth) {
            super(SearchPosts.class, nextDoorAPIAuth);
        }

        @Override
        protected String getPath() {
            return "";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public SearchPosts execute() throws APIRequestException {
            return null;
        }

        public static class NextDoorAPISearchPostsBySignals extends NextDoorAPIRequest<SearchPostsBySignals> implements NextDoorAPIExecute<SearchPostsBySignals> {
            public NextDoorAPISearchPostsBySignals(NextDoorAPIAuth nextDoorAPIAuth) {
                super(SearchPostsBySignals.class, nextDoorAPIAuth);
            }

            @Override
            protected String getPath() {
                return "";
            }

            @Override
            protected void validateRequiredParams() {

            }

            @Override
            public SearchPostsBySignals execute() throws APIRequestException {
                return null;
            }
        }

        public static class NextDoorAPISearchFSFItems extends NextDoorAPIRequest<SearchFSFItems> implements NextDoorAPIExecute<SearchFSFItems> {
            public NextDoorAPISearchFSFItems(NextDoorAPIAuth nextDoorAPIAuth) {
                super(SearchFSFItems.class, nextDoorAPIAuth);
            }

            @Override
            protected String getPath() {
                return "";
            }

            @Override
            protected void validateRequiredParams() {

            }

            @Override
            public SearchFSFItems execute() throws APIRequestException {
                return null;
            }
        }

        public static class NextDoorAPISearchEvents extends NextDoorAPIRequest<SearchEvents> implements NextDoorAPIExecute<SearchEvents> {
            public NextDoorAPISearchEvents(NextDoorAPIAuth nextDoorAPIAuth) {
                super(SearchEvents.class, nextDoorAPIAuth);
            }

            @Override
            protected String getPath() {
                return "";
            }

            @Override
            protected void validateRequiredParams() {

            }

            @Override
            public SearchEvents execute() throws APIRequestException {
                return null;
            }
        }

        public static class NextDoorAPISearchBusinesses extends NextDoorAPIRequest<SearchBusinesses> implements NextDoorAPIExecute<SearchBusinesses> {
            public NextDoorAPISearchBusinesses(NextDoorAPIAuth nextDoorAPIAuth) {
                super(SearchBusinesses.class, nextDoorAPIAuth);
            }

            @Override
            protected String getPath() {
                return "";
            }

            @Override
            protected void validateRequiredParams() {

            }

            @Override
            public SearchBusinesses execute() throws APIRequestException {
                return null;
            }
        }
    }
}
