package edu.pet.vkazakov.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

// TABLE balance is история изменения баланса
@Data
@Entity
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long balance_id;
    private Long contract_id;
    private Long trx_id;
    @DateTimeFormat(pattern= GlobalConstant.patternTime)
    private Date tsfrom;
    @DateTimeFormat(pattern= GlobalConstant.patternTime)
    private Date tsto;
    private double balance;

}
