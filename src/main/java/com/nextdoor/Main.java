package com.nextdoor;

import com.nextdoor.data.CampaignRequest;
import com.nextdoor.impl.advertise.NextDoorAPICampaign;

public class Main {
    public static void main(String[] args) {
        NextDoorAPICampaign nextDoorAPICampaign = new NextDoorAPICampaign();
        CampaignRequest nextDoor = nextDoorAPICampaign
                .getObj()
                .builder()
                .name("Next Door")
                .advertiserId("123123")
                .token("Test my new token")
                .build();

        nextDoorAPICampaign.setObj(nextDoor);

        System.out.println(nextDoorAPICampaign.getObj());
    }
}
