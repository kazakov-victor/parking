package edu.pet.vkazakov.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

//discount IS 'Скидки';

@Data
@Entity
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discount_id;
    private Long contract_id;
    private Long period_id;
    private Long charge_id;
    private Long trx_id;
    private Long revoke_id;
    private Long revokedby_id;
    @DateTimeFormat(pattern= GlobalConstant.patternTime)
    private Timestamp ts;
    @DateTimeFormat(pattern= GlobalConstant.patternTime)
    private Timestamp tscreate;
    private double amount;

}
