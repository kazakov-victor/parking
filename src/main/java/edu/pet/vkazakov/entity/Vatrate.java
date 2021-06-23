package edu.pet.vkazakov.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

import static edu.pet.vkazakov.entity.GlobalConstant.patternDate;

/* Ставка НДС
   percent is 'Ставка НДС в процентах';
   dtfrom is 'Дата начала действия ставки НДС';
   dtto is 'Дата завершения действия ставки НДС';
*/

@Data
@Entity

public class Vatrate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vatrate_id;
    private double percent;
    @DateTimeFormat(pattern=patternDate)
    private Date dtfrom;
    @DateTimeFormat(pattern=patternDate)
    private Date dtto;

}