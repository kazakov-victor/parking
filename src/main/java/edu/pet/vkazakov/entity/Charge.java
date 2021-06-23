package edu.pet.vkazakov.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/** charge IS 'Начисления';
vatincluded IS 'Начисление включает НДС';
count количество оказанных услуг
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Charge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long charge_id;
    private Long contract_id;
    private Long period_id;
    private Long income_type_id;
    private double count;
    private double amount;

  /*  private Long trx_id;
    private Long revoke_id;
    private Long revokedby_id;
    private boolean vatincluded;
    @DateTimeFormat(pattern=patternTime)
    private Timestamp ts;
    @DateTimeFormat(pattern=patternTime)
    private Timestamp tscreate;
    private String note;*/

    public Charge(Long contract_id, Long period_id, Long income_type_id, double count, double amount) {
        this.contract_id = contract_id;
        this.period_id = period_id;
        this.income_type_id = income_type_id;
        this.count = count;
        this.amount = amount;
    }
}
