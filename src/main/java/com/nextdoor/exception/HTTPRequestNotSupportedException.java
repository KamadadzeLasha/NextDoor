package com.nextdoor.exception;

public class HTTPRequestNotSupportedException extends APIRequestException {
    public HTTPRequestNotSupportedException() {
    }

    public HTTPRequestNotSupportedException(String s) {
        super(s);
    }

    public HTTPRequestNotSupportedException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public HTTPRequestNotSupportedException(Throwable throwable) {
        super(throwable);
    }

    public HTTPRequestNotSupportedException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
