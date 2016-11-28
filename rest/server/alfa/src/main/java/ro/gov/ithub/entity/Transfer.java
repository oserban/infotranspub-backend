package ro.gov.ithub.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import ro.gov.ithub.base.BaseEntity;
import ro.gov.ithub.entity.util.TransferType;

import javax.persistence.*;

/**
 * Created by Mihnea on 11/12/16.
 */
@Data
@NoArgsConstructor
@Entity
@Table
public class Transfer implements BaseEntity {

    static final String TABLE_NAME = "TRANSFER";
    static final String COLUMN_FROM_STOP_ID = "FROM_STOP_ID";
    static final String COLUMN_TO_STOP_ID = "TO_STOP_ID";

    @Id
    @Column(name = COLUMN_TO_STOP_ID, nullable = false)
    private Integer toStopId;

    @Id
    @Column(name = COLUMN_FROM_STOP_ID, nullable = false)
    private Integer fromStopId;

    @Enumerated
    private TransferType transferType;

    @Column
    private Double minTransferTime;

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
