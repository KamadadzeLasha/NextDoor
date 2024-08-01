package com.nextdoor;

import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.CampaignCreationException;
import com.nextdoor.impl.NextDoorAPICampaign;
import com.nextdoor.models.Campaign;

public class Main {
    public static void main(String[] args) throws CampaignCreationException {
        Campaign newCampaign = new NextDoorAPICampaign("advId", getApiAuth()).createCampaign()
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
