package com.nextdoor.share;

import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.NextDoorModel;

public interface NextDoorAPIUpdateEdit<T extends NextDoorModel> {
    T update() throws APIRequestException;
}