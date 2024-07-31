package com.nextdoor.impl.advertise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nextdoor.api.share.NextDoorAPIRequest;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.data.CampaignRequest;

import java.util.HashMap;

public class NextDoorAPICampaign extends NextDoorAPIRequest<CampaignRequest> {
    public NextDoorAPICampaign() {
        super(CampaignRequest.class);
    }

    public NextDoorAPICampaign(NextDoorAPIAuth nextDoorAPIAuth) {
        super(CampaignRequest.class);
        getObj().setNextDoorAPIAuth(nextDoorAPIAuth);
    }

    public CampaignRequest createCampaign() throws UnirestException, JsonProcessingException {
        String url = DefaultURLS.DEFAULT_FULL_API_URL + getAPIRequestPath() + "/create";
        return sendPostRequest(url, new HashMap<>(), CampaignRequest.class);
    }

    @Override
    public String getAPIRequestPath() {
        return "campaign";
    }
}