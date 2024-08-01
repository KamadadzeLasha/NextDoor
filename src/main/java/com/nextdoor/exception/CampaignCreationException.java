package com.nextdoor.exception;

public class CampaignCreationException extends APIRequestException {
    public CampaignCreationException() {
    }

    public CampaignCreationException(String s) {
        super(s);
    }

    public CampaignCreationException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public CampaignCreationException(Throwable throwable) {
        super(throwable);
    }

    public CampaignCreationException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
