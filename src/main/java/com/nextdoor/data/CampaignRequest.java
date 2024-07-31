package com.nextdoor.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nextdoor.api.response.NextDoorAPIRequestNode;
import com.nextdoor.auth.NextDoorAPIAuth;

import java.util.Objects;

public class CampaignRequest extends NextDoorAPIRequestNode {
    @JsonProperty("advertiser_id")
    protected String advertiserId;

    @JsonProperty("name")
    protected String name;

    @JsonProperty("objective")
    protected String objective;

    public CampaignRequest() {
        super("");
    }

    public CampaignRequest(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public CampaignRequest(NextDoorAPIAuth nextDoorAPIAuth, CampaignRequest campaignRequest) throws JsonProcessingException {
        super(nextDoorAPIAuth, new ObjectMapper().writeValueAsString(campaignRequest));
    }

    public CampaignRequest(NextDoorAPIAuth nextDoorAPIAuth, String advertiserId, String name, String objective) {
        super(nextDoorAPIAuth);
        this.advertiserId = advertiserId;
        this.name = name;
        this.objective = objective;
    }

    public CampaignRequest(NextDoorAPIAuth nextDoorAPIAuth, String objAsStringJson, String advertiserId, String name, String objective) {
        super(nextDoorAPIAuth, objAsStringJson);
        this.advertiserId = advertiserId;
        this.name = name;
        this.objective = objective;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public String getName() {
        return name;
    }

    public String getObjective() {
        return objective;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public CampaignRequestBuilder builder() {
        return new CampaignRequestBuilder();
    }

    public CampaignRequest defaultCampaignRequset() {
        return new CampaignRequest();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CampaignRequest campaignRequest = (CampaignRequest) object;
        return Objects.equals(advertiserId, campaignRequest.advertiserId) && Objects.equals(name, campaignRequest.name) && Objects.equals(objective, campaignRequest.objective);
    }

    @Override
    public int hashCode() {
        return Objects.hash(advertiserId, name, objective);
    }

    @Override
    public String toString() {
        return "CampaignRequest{" +
                "advertiserId='" + advertiserId + '\'' +
                ", name='" + name + '\'' +
                ", objective='" + objective + '\'' +
                ", nextDoorAPIAuth=" + nextDoorAPIAuth +
                ", objAsString='" + objAsString + '\'' +
                '}';
    }

    public static class CampaignRequestBuilder {
        private final CampaignRequest campaignRequest = new CampaignRequest();

        public CampaignRequestBuilder() {

        }

        public CampaignRequestBuilder(String token) {
            this.campaignRequest.nextDoorAPIAuth = new NextDoorAPIAuth(token);
        }

        public CampaignRequestBuilder name(String name) {
            this.campaignRequest.name = name;

            return this;
        }

        public CampaignRequestBuilder advertiserId(String advertiserId) {
            this.campaignRequest.advertiserId = advertiserId;

            return this;
        }

        public CampaignRequestBuilder objective(String objective) {
            this.campaignRequest.objective = objective;

            return this;
        }

        public CampaignRequestBuilder token(String token) {
            this.campaignRequest.nextDoorAPIAuth.setToken(token);

            return this;
        }

        public CampaignRequest build() {
            ObjectMapper objectMapper = this.campaignRequest.getObjectMapper();
            try {
                this.campaignRequest.objAsString = objectMapper.writeValueAsString(this.campaignRequest);
            } catch (JsonProcessingException e) {
                this.campaignRequest.nextDoorAPIAuth.log("Error while writing to JSON: " + e.getMessage());
            }
            return campaignRequest;
        }
    }
}
