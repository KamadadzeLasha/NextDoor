package com.nextdoor.share;

import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.NextDoorModel;

public interface NextDoorAPICreate<T extends NextDoorModel> {
    T create() throws APIRequestException;
}
