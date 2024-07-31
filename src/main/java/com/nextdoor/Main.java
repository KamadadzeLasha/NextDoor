package com.nextdoor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nextdoor.data.CampaignRequest;
import com.nextdoor.impl.advertise.NextDoorAPICampaign;

public class Main {
    public static void main(String[] args) throws UnirestException, JsonProcessingException {
        NextDoorAPICampaign nextDoorAPICampaign = new NextDoorAPICampaign()
                .name("Name");

        System.out.println(nextDoorAPICampaign.getObj().getObjAsString());
//        nextDoorAPICampaign.setObj(nextDoor);
//        nextDoorAPICampaign.createCampaign();
    }
}
