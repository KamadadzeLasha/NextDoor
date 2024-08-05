package com.nextdoor.util;

public final class NextDoorUtil {
    public static void ensureStringNotNull(Object str, String name) {
        ensureStringNotNull(String.valueOf(str), name);
    }

    public static void ensureStringNotNull(String str, String name) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException(name + " can not be null or empty.");
        }
    }

    public static void ensureObjectNotNull(Object object, String name) {
        if (object == null) {
            throw new IllegalArgumentException(name + " can not be null.");
        }
    }
}
