package edu.pet.vkazakov.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

/** contract 'Договора с клиентами';
* contract.dtfrom is 'Дата начала действия договора';
* contract.dtto is 'Дата завершения действия договора. Если не заполнена, договор с прологнацией';
*/

 @Data
 @AllArgsConstructor
 @NoArgsConstructor
 @ToString(exclude = "incomes")

 @Entity

public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contract_id;
    private Long number;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name="person_id", nullable=false)
    private Person person;

    private Double balance;
    @DateTimeFormat(pattern= GlobalConstant.patternDate)
    private Date dtfrom;
    @DateTimeFormat(pattern= GlobalConstant.patternDate)
    private Date dtto;
    private String note;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Income> incomes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contract", cascade = CascadeType.ALL)
    private Set<Payment> payments;
}
