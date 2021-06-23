package edu.pet.vkazakov.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

import static edu.pet.vkazakov.entity.GlobalConstant.patternDate;

//TABLE invoice IS 'Документы к оплате'

@Data
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoice_id;
    private  Long contract_id;
    private Long pid_period;
    @DateTimeFormat(pattern=patternDate)
    private Date dt;
    @DateTimeFormat(pattern=patternDate)
    private Date dtcreate;
    private boolean payed;

}
