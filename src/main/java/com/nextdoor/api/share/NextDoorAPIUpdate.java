package com.nextdoor.api.share;

import com.nextdoor.api.response.NextDoorAPIRequestNode;
import com.nextdoor.exception.CampaignUpdateException;

public interface NextDoorAPIUpdate<T extends NextDoorAPIRequestNode> {
    T update() throws CampaignUpdateException;
}
