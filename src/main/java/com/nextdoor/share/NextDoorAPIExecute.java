package com.nextdoor.share;

import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.NextDoorModel;

public interface NextDoorAPIExecute<T extends NextDoorModel> {
    T execute() throws APIRequestException;
}
