package ro.gov.ithub.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ro.gov.ithub.base.BaseEntity;
import ro.gov.ithub.entity.util.FareAttributePaymentMethod;
import ro.gov.ithub.entity.util.FareAttributeTransfers;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table
@EqualsAndHashCode(of={"fareId"})
public class FareAttribute implements BaseEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.PROPERTY)
    private Integer fareId;

    @ManyToOne
    private FareRule fareRule;

    @Column(nullable = false)
    private Double price;

//    TODO use java.util.Currency
    @Column(nullable = false)
    private String currencyType;

    @Enumerated
    private FareAttributePaymentMethod paymentMethod;

    @Enumerated
    private FareAttributeTransfers transfers;

    @Column
    private Integer transferDuration;

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
