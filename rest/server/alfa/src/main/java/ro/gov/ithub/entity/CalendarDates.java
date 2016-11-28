package ro.gov.ithub.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import ro.gov.ithub.base.BaseEntity;
import ro.gov.ithub.entity.util.CalendarDatesPk;
import ro.gov.ithub.entity.util.ExceptionType;

import javax.persistence.*;

/**
 * Created by Mihnea on 11/12/16.
 */
@Data
@NoArgsConstructor
@Entity
@Table
public class CalendarDates implements BaseEntity {

    @EmbeddedId
    private CalendarDatesPk calendarDatesPk;

    @Enumerated(EnumType.ORDINAL)
    private ExceptionType exceptionType;

    @ManyToOne
    private Calendar calendar;

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
