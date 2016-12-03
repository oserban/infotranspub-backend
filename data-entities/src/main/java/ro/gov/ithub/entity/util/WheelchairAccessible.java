package ro.gov.ithub.entity.util;

import lombok.Getter;

public enum WheelchairAccessible {

    NO_INFO(0),
    CAN_ACCOMODATE(1),
    CAN_NOT_ACCOMODATE(2);

    @Getter
    private int accessible;

    WheelchairAccessible(int wheelchairAccessible) {
        this.accessible = wheelchairAccessible;
    }
}
