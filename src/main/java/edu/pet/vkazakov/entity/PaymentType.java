package edu.pet.vkazakov.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

//'Типы платежей'

@Data
@ToString(exclude = "payments")
@Table(name = "payment_type")
@Entity
public class PaymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payment_type_id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "paymentType")
    private List<Payment> payments;
}
