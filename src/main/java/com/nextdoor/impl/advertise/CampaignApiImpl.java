package com.nextdoor.impl.advertise;

import com.google.gson.reflect.TypeToken;
import com.nextdoor.NextDoorResponse;
import com.nextdoor.TwitterAdsClient;
import com.nextdoor.api.advertise.CampaignApi;
import com.nextdoor.api.advertise.NextDoorException;
import com.nextdoor.models.Campaign;
import com.nextdoor.util.NextDoorUtil;

import java.lang.reflect.Type;

public class CampaignApiImpl implements CampaignApi {
    private final TwitterAdsClient twitterAdsClient;
    public CampaignApiImpl(TwitterAdsClient twitterAdsClient){
        this.twitterAdsClient = twitterAdsClient;
    }

    @Override
    public NextDoorResponse<Campaign> createCampaign(String advertiserId, String name, String objective) throws NextDoorException {
        NextDoorUtil.ensureNotNull(advertiserId, "Advertiser Id");

        Type type = new TypeToken<BaseAdsResponse<Campaign>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, parameters, type, HttpVerb.POST);
    }
}