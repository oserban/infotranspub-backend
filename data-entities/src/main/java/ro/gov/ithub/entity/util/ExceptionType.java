package ro.gov.ithub.entity.util;

import lombok.Getter;

public enum ExceptionType {

    ADDED(1),
    REMOVED(2);

    @Getter
    private int type;

    ExceptionType(int exceptionType) {
        this.type = exceptionType;
    }

}
