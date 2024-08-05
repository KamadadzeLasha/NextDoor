package com.nextdoor.share;

import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.NextDoorModel;

public interface NextDoorAPIUpdate<T extends NextDoorModel> {
    T update() throws APIRequestException;
}
