package edu.pet.vkazakov.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

import static edu.pet.vkazakov.entity.GlobalConstant.patternTime;

// TABLE vat is Документы НДС

@Data
@Entity
public class Vat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vat_id;
    private Long vatrate_id;
    private Long charge_id;
    private Long trx_id;
    private Long period_id;
    private Long revoke_id;
    private Long revokedby_id;
    @DateTimeFormat(pattern=patternTime)
    private Timestamp ts;
    @DateTimeFormat(pattern=patternTime)
    private Timestamp tscreate;
    private double amount;

}
