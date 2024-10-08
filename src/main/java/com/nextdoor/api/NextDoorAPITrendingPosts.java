package com.nextdoor.api;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.*;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.share.interfaces.NextDoorAPIExecuteList;
import com.nextdoor.util.NextDoorUtil;

import java.util.List;

import static com.nextdoor.constants.DefaultURLS.DEFAULT_URL;

public class NextDoorAPITrendingPosts extends NextDoorAPIRequestNode {
    public NextDoorAPITrendingPosts() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPITrendingPosts(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPISearchPosts searchPosts() {
        return new NextDoorAPISearchPosts(this.nextDoorAPIAuth);
    }

    public NextDoorAPIStateList stateList() {
        return new NextDoorAPIStateList(this.nextDoorAPIAuth);
    }

    public NextDoorAPITargetingPostsForCity targetingPostsForCity() {
        return new NextDoorAPITargetingPostsForCity(this.nextDoorAPIAuth);
    }

    public NextDoorAPITargetingPostsForStateWithPagination targetingPostsForStateWithPagination() {
        return new NextDoorAPITargetingPostsForStateWithPagination(this.nextDoorAPIAuth);
    }

    public static class NextDoorAPISearchPosts extends NextDoorAPIRequest<City> implements NextDoorAPIExecuteList<City> {
        public NextDoorAPISearchPosts(NextDoorAPIAuth nextDoorAPIAuth) {
            super(City.class, nextDoorAPIAuth);

            this.addHeader(nextDoorAPIAuth.getTokenHeader());
        }

        @Override
        protected String getPath() {
            return DEFAULT_URL + "partner_api/v1/city_list";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public List<City> execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequestForList(HttpMethod.GET, getPath(), ConversionType.NONE);
            } catch (APIRequestException e) {
                throw new NextDoorAPICampaign.NextDoorAPICreateCampaign.CampaignCreationException("Can't create campaign, because of: " + e.getLocalizedMessage());
            }
        }
    }

    public static class NextDoorAPIStateList extends NextDoorAPIRequest<State> implements NextDoorAPIExecuteList<State> {
        public NextDoorAPIStateList(NextDoorAPIAuth nextDoorAPIAuth) {
            super(State.class, nextDoorAPIAuth);
        }

        @Override
        protected String getPath() {
            return "";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public List<State> execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequestForList(HttpMethod.GET, getPath(), ConversionType.NONE);
            } catch (APIRequestException e) {
                throw new NextDoorAPICampaign.NextDoorAPICreateCampaign.CampaignCreationException("Can't create campaign, because of: " + e.getLocalizedMessage());
            }
        }
    }

    public static class NextDoorAPITargetingPostsForCity extends NextDoorAPIRequest<TargetingPostsCity> implements NextDoorAPIExecute<TargetingPostsCity> {
        private String id;

        public NextDoorAPITargetingPostsForCity(NextDoorAPIAuth nextDoorAPIAuth) {
            super(TargetingPostsCity.class, nextDoorAPIAuth);

            this.addHeader(nextDoorAPIAuth.getTokenHeader());
        }

        public NextDoorAPITargetingPostsForCity setId(String id) {
            this.id = id;

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_URL + "partner_api/v1/city_digest/" + this.id;
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.id, "ID");
        }

        @Override
        public TargetingPostsCity execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new NextDoorAPIAdvertiser.NextDoorAPICreateAdvertiser.AdvertiserCreationException("Can't create advertiser campaign, because of: " + e.getLocalizedMessage());
            }
        }
    }

    public static class NextDoorAPITargetingPostsForStateWithPagination extends NextDoorAPIRequest<TargetingStateWithPagination> implements NextDoorAPIExecute<TargetingStateWithPagination> {
        private String stateId;
        private Integer pageNum;

        public NextDoorAPITargetingPostsForStateWithPagination(NextDoorAPIAuth nextDoorAPIAuth) {
            super(TargetingStateWithPagination.class, nextDoorAPIAuth);
        }

        public NextDoorAPITargetingPostsForStateWithPagination setStateId(String stateId) {
            this.stateId = stateId;

            return this;
        }

        public NextDoorAPITargetingPostsForStateWithPagination setPageNum(Integer pageNum) {
            this.pageNum = pageNum;

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_URL + "partner_api/v1/state_digest/" + this.stateId + "/page/" + (this.pageNum == null ? "current_page" : this.pageNum);
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.stateId, "stateID");
        }

        @Override
        public TargetingStateWithPagination execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new NextDoorAPIAdvertiser.NextDoorAPICreateAdvertiser.AdvertiserCreationException("Can't create advertiser campaign, because of: " + e.getLocalizedMessage());
            }
        }
    }
}
