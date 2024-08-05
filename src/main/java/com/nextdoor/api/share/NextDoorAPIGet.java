package com.nextdoor.api.share;

import com.nextdoor.api.response.NextDoorAPIRequestNode;
import com.nextdoor.exception.APIRequestException;

public interface NextDoorAPIGet<T extends NextDoorAPIRequestNode> {
    T get() throws APIRequestException;
}
