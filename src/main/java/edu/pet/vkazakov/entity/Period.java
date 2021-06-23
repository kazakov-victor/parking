package edu.pet.vkazakov.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

//period IS 'Бухгалтерские (отчетные) периоды'

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long period_id;
    @DateTimeFormat(pattern= GlobalConstant.patternDate)
    private Date dtfrom;
    @DateTimeFormat(pattern= GlobalConstant.patternDate)
    private Date dtto;
    @DateTimeFormat(pattern= GlobalConstant.patternTime)
    private Timestamp tsclose;
    private boolean closed;

    public Period(Date dtfrom, Date dtto, Timestamp tsclose, boolean closed) {
        this.dtfrom = dtfrom;
        this.dtto = dtto;
        this.tsclose = tsclose;
        this.closed = closed;
    }
}
