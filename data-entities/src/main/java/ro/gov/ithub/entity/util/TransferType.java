package ro.gov.ithub.entity.util;

import lombok.Getter;

public enum TransferType {

    RECOMMENDED(0),
    TIMED_WITH_WAITING(1),
    REQ_MIN_TIME(2),
    NO_TRANSFER(3);

    @Getter
    private int transferType;

    TransferType(int type) {
        this.transferType = type;
    }
}
