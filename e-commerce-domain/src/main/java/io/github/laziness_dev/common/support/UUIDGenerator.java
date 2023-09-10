package io.github.laziness_dev.common.support;

import java.util.UUID;

public class UUIDGenerator {

    public static String generateFromKey(String key) {
        return UUID.fromString(key).toString();
    }
}
