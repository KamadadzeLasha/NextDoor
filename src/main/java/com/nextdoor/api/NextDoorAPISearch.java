package com.nextdoor.api;

import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.search.SearchPosts;
import com.nextdoor.models.search.SearchPostsBySignals;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;

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
    }
}
