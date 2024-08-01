package com.nextdoor;

import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.CampaignCreationException;
import com.nextdoor.impl.NextDoorAPIAdvertiser;
import com.nextdoor.impl.NextDoorAPICampaign;
import com.nextdoor.models.Advertiser;
import com.nextdoor.models.Campaign;

public class Main {
    public static void main(String[] args) throws CampaignCreationException {
        Advertiser advertiser = new NextDoorAPIAdvertiser(getApiAuth())
                .createAdvertiser()
                .name("My Advertiser")
                .websiteUrl("https://developer.nextdoor.com/reference/advertiser-create")
                .categoryId("My category")
                .create();

        String advertiserId = advertiser.getId();
        System.out.println(advertiserId);

        Campaign newCampaign = new NextDoorAPICampaign(advertiserId, getApiAuth()).createCampaign()
                .setName("New Campaign")
                .setObjective(Campaign.Objective.AWARENESS)
                .create();

        System.out.println(newCampaign.getStatus());
    }

    public static NextDoorAPIAuth getApiAuth() {
        NextDoorAPIAuth nextDoorAPIAuth = new NextDoorAPIAuth();
        nextDoorAPIAuth.setToken("your-token");
        nextDoorAPIAuth.enableDebug(true);

        return nextDoorAPIAuth;
    }
}
