package com.nextdoor.api.share;

import com.nextdoor.api.response.NextDoorAPIRequestNode;
import com.nextdoor.exception.CampaignCreationException;

public interface NextDoorAPICreate<T extends NextDoorAPIRequestNode> {
    T create() throws CampaignCreationException;
}
