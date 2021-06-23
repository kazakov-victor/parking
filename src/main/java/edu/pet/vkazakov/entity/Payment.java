package edu.pet.vkazakov.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * payment IS 'Платежи';
 * sid_external IS 'идентификатор во внешних системах';
*/

@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payment_id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "contract_id") //, nullable = false)
    private Contract contract;
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, optional = false )
    @JoinColumn(name="payment_type_id", nullable=false)
    private PaymentType paymentType;
    private Long period_id;
 //   private Long trx_id;
 //   private Long revoke_id;
 //   private Long revokedby_id;
    @DateTimeFormat(pattern= GlobalConstant.patternTime)
    private Timestamp ts;
    @DateTimeFormat(pattern= GlobalConstant.patternTime)
    private Timestamp tscreate;
    @DateTimeFormat(pattern= GlobalConstant.patternTime)
    private Timestamp tsagent;
    private double amount;
    private String note;

}
