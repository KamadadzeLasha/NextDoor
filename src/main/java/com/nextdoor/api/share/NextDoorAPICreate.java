package com.nextdoor.api.share;

import com.nextdoor.api.response.NextDoorModel;
import com.nextdoor.exception.APIRequestException;

public interface NextDoorAPICreate<T extends NextDoorModel> {
    T create() throws APIRequestException;
}
