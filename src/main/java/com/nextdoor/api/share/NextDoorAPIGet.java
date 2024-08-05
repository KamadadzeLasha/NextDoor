package com.nextdoor.api.share;

import com.nextdoor.api.response.NextDoorModel;
import com.nextdoor.exception.APIRequestException;

public interface NextDoorAPIGet<T extends NextDoorModel> {
    T get() throws APIRequestException;
}
