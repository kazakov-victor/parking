package edu.pet.vkazakov.entity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

//price IS 'Стоимость услуг';

@Data
@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long price_id;
    @DateTimeFormat(pattern= GlobalConstant.patternDate)
    private Date dtfrom;
    @DateTimeFormat(pattern= GlobalConstant.patternDate)
    private Date dtto;
   // @NotNull
    private double amount;
   // check
   @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JoinColumn(name = "income_type_id") //, nullable = false)
   private IncomeType incomeType;
}
