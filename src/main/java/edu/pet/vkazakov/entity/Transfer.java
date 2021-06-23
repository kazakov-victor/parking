package edu.pet.vkazakov.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

import static edu.pet.vkazakov.entity.GlobalConstant.patternTime;

// TABLE transfer IS 'Переносы денежных средств';
@Data
@Entity
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transfer_id;
    private Long period_id;
    private Long contract_from_id;
    private Long contract_to_id;
    private Long trx_from_id;
    private Long trx_to_id;
    private Long revoke_id;
    private Long revokedby_id;
    @DateTimeFormat(pattern=patternTime)
    private Date ts;
    @DateTimeFormat(pattern=patternTime)
    private Date tscreate;// TIMESTAMP NOT NULL,
    private double amount;
    private String note;
}
