package com.nextdoor.exception;

public class CampaignUpdateException extends APIRequestException {
    public CampaignUpdateException() {
    }

    public CampaignUpdateException(String s) {
        super(s);
    }

    public CampaignUpdateException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public CampaignUpdateException(Throwable throwable) {
        super(throwable);
    }

    public CampaignUpdateException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
