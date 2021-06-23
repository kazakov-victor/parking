package edu.pet.vkazakov.entity;

import lombok.Data;

import javax.persistence.*;

//invoice_trx IS 'Начисления включенные в счет'

@Data
@Table(name = "invoice_trx")
@Entity
public class InvoiceTrx {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoice_trx_id;
    private Long trx_id;
    private Long invoice_id;

}
