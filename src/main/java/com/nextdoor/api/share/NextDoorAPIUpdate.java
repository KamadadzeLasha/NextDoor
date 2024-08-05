package com.nextdoor.api.share;

import com.nextdoor.api.response.NextDoorModel;
import com.nextdoor.exception.APIRequestException;

public interface NextDoorAPIUpdate<T extends NextDoorModel> {
    T update() throws APIRequestException;
}
