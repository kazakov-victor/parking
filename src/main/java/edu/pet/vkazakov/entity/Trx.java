package edu.pet.vkazakov.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

import static edu.pet.vkazakov.entity.GlobalConstant.patternTime;

// 'Проводки';
//  trx.ts IS 'Дата и время проводки';

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Trx {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trx_id;
    private String sid_ledgertype;
    private String sid_trxtype;
    private Long period_id;
    private Long contract_id;
    @DateTimeFormat(pattern=patternTime)
    private Timestamp ts;
    @DateTimeFormat(pattern=patternTime)
    private Timestamp tscreate;
    private Double amount;
    private Long count;

    public Trx(String sid_ledgertype, String sid_trxtype, Long period_id, Long contract_id, Timestamp ts, Timestamp tscreate, Double amount, Long count) {
        this.sid_ledgertype = sid_ledgertype;
        this.sid_trxtype = sid_trxtype;
        this.period_id = period_id;
        this.contract_id = contract_id;
        this.ts = ts;
        this.tscreate = tscreate;
        this.amount = amount;
        this.count = count;
    }
}
