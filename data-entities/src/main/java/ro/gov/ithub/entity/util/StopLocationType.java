package ro.gov.ithub.entity.util;

import lombok.Getter;

public enum StopLocationType {

    STOP(0),
    STATION(1);

    @Getter
    private int locationType;

    StopLocationType(int type) { this.locationType = type; }
}
