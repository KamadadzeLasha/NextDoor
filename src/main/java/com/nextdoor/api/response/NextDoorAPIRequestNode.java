package com.nextdoor.api.response;

import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.util.NextDoorUtil;

public abstract class NextDoorAPIRequestNode implements NextDoorAPIResponse {
    protected NextDoorAPIAuth nextDoorAPIAuth;

    public NextDoorAPIRequestNode() {
        this.nextDoorAPIAuth = new NextDoorAPIAuth();
    }

    public NextDoorAPIRequestNode(NextDoorAPIAuth nextDoorAPIAuth) {
        NextDoorUtil.ensureObjectNotNull(nextDoorAPIAuth, "nextDoorAPIAuth");
        this.nextDoorAPIAuth = nextDoorAPIAuth;
    }

    public NextDoorAPIAuth getNextDoorAPIAuth() {
        return nextDoorAPIAuth;
    }

    public void setNextDoorAPIAuth(NextDoorAPIAuth nextDoorAPIAuth) {
        this.nextDoorAPIAuth = nextDoorAPIAuth;
    }
}
