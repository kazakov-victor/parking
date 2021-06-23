package edu.pet.vkazakov.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

import static edu.pet.vkazakov.entity.GlobalConstant.patternDate;

@Data

@Entity
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long income_id;
    @DateTimeFormat(pattern=patternDate)
    private Date dtfrom;
    @DateTimeFormat(pattern=patternDate)
    private Date dtto;
    private Double quantity;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER,optional = false )
    @JoinColumn(name="income_type_id", nullable=false)
    private IncomeType incomeType;

    @ManyToOne (cascade = {CascadeType.ALL}) //, optional = false)
    @JoinColumn(name="contract_id")
    private Contract contract;

    @Override
    public String toString() {
        return "Income{" +
                "income_id=" + income_id +
                ", dtfrom=" + dtfrom +
                ", dtto=" + dtto +
                ", quantity=" + quantity +
                '}';
    }
}
