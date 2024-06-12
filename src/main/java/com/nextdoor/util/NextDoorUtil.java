package com.nextdoor.util;

public final class NextDoorUtil {
    public static void ensureNotNull(Object object, String name) {
        if (object == null) {
            throw new IllegalArgumentException(name + " can not be null.");
        }
    }
}
