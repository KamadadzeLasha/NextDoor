package com.nextdoor.api.response;

import com.nextdoor.auth.NextDoorAPIAuth;

public abstract class NextDoorAPIRequestNode implements NextDoorAPIResponse {
    protected NextDoorAPIAuth nextDoorAPIAuth;

    public NextDoorAPIRequestNode() {

    }

    public NextDoorAPIAuth getNextDoorAPIAuth() {
        return nextDoorAPIAuth;
    }

    public void setNextDoorAPIAuth(NextDoorAPIAuth nextDoorAPIAuth) {
        this.nextDoorAPIAuth = nextDoorAPIAuth;
    }
}
