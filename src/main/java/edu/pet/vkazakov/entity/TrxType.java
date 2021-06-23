package edu.pet.vkazakov.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//'Тип проведенных операций'
// optype IS 'Тип операции'

@Data
@Entity
@Table(name = "trx_type")
public class TrxType {
    @Id
    private String sid;
    private String name;
    private String sid_ledgertype;
    private String optype;

}
