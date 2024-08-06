package com.nextdoor.share;

import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.NextDoorModel;

public interface NextDoorAPIEdit<T extends NextDoorModel> {
    T edit() throws APIRequestException;
}