package com.nextdoor.share;

import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.NextDoorModel;

public interface NextDoorAPIGet<T extends NextDoorModel> {
    T get() throws APIRequestException;
}
