package edu.pet.vkazakov.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

//remain IS 'Корректировки и остатки балансов возникающие при миграции';

@Data
@Entity
public class Remain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long remain_id;
    private String sid_ledgertype;
    private Long contract_id;
    private Long period_id;
    private Long trx_id;
    private Long revoke_id;
    private Long revokedby_id;
    @DateTimeFormat(pattern= GlobalConstant.patternTime)
    private Date ts;
    @DateTimeFormat(pattern= GlobalConstant.patternTime)
    private Date tscreate;
    private double remain;
    private String note;

}
