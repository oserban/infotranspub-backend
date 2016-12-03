package ro.gov.ithub.entity.util;

import lombok.Getter;

public enum FrequencyExactTimes {

    UNSCHEDULED(0),
    EXACTLY_SCHEDULED(1);

    @Getter
    private int exactTimes;

    FrequencyExactTimes(int exactTimes) { this.exactTimes = exactTimes; }
}
