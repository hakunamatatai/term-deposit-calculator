package com.ferocia.Enum;

import java.util.Arrays;

public enum InterestPaymentType {

    MONTHLY("Paid_Monthly", 12),
    QUARTERLY("PAID_QUARTERLY", 4),
    ANNUALLY("PAID_ANNUALLY", 1),

    AT_MATURITY("PAID_AT_MATURITY", 1),
    ;

    private String typeName;
    private int timeCount;

    InterestPaymentType(String typeName, int timeCount) {
        this.typeName = typeName;
        this.timeCount = timeCount;
    }

    public int getTimeCount() {
        return timeCount;
    }

    public String getTypeName() {
        return typeName;
    }

    public static InterestPaymentType fromString(String name) {
        return Arrays.stream(values())
                .filter(c -> c.typeName.equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown type: " + name));
    }
}