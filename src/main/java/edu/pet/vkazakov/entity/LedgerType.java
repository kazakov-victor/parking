package edu.pet.vkazakov.entity;
// ledgertype is 'Тип бухгалтерского счета';

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ledger_type")
public class LedgerType {
       @Id
       String sid;
       String name;
}