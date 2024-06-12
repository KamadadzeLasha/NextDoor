package com.nextdoor.api.advertise;

import com.nextdoor.NextDoorResponse;
import com.nextdoor.models.Campaign;

public interface CampaignApi{
    NextDoorResponse<Campaign> createCampaign(String advertiser_id, String name, String objective) throws NextDoorException;
}