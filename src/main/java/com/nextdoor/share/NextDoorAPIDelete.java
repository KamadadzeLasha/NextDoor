package com.nextdoor.share;

import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.NextDoorModel;

public interface NextDoorAPIDelete<T extends NextDoorModel> {
    T delete() throws APIRequestException;
}