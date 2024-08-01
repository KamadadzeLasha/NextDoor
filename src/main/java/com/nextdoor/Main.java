package com.nextdoor;

import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.CampaignCreationException;
import com.nextdoor.impl.advertise.NextDoorAPICampaign;
import com.nextdoor.models.Campaign;

public class Main {
    public static void main(String[] args) throws CampaignCreationException {
        Campaign newCampaign = new NextDoorAPICampaign("123123", getApiAuth()).createCampaign()
                .setName("New Campaign")
                .setObjective(Campaign.Objective.AWARENESS)
                .execute();

        System.out.println(newCampaign.getStatus());
    }

    public static NextDoorAPIAuth getApiAuth() {
        NextDoorAPIAuth nextDoorAPIAuth = new NextDoorAPIAuth();
        nextDoorAPIAuth.setToken("123123");
        nextDoorAPIAuth.enableDebug(true);

        return nextDoorAPIAuth;
    }
}
