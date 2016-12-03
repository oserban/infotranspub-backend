package ro.gov.ithub.entity.util;

import lombok.Getter;

public enum FareAttributeTransfers {

    NO_TRANSFERS(0),
    POSSIBLE_ONCE(1),
    POSSIBLE_TWICE(2),
    POSSIBLE_UNLIMITED();

    @Getter
    private Integer paymentMethod;

    FareAttributeTransfers(Integer method) {
        this.paymentMethod = method;
    }

    FareAttributeTransfers() { this(null); }
}
