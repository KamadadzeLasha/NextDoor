package com.nextdoor.share;

import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.NextDoorModel;

import java.util.List;

public interface NextDoorAPIExecuteList<T extends NextDoorModel> {
    List<T> execute() throws APIRequestException;
}
