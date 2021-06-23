package edu.pet.vkazakov.entity;
//TABLE invoice_cover_trx IS 'Покрытие счетов платежами';

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "invoice_cover_trx")
@Entity
public class InvoiceCoverTrx {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoice_cover_id;
    private Long trx_id;
    private Long invoice_id;

}
