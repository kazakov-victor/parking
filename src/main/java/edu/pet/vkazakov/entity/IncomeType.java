package edu.pet.vkazakov.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Table(name = "income_type")
@Entity
public class IncomeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long income_type_id;
    private Basis basis;
    private String name;
    private String note;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "incomeType")
    private List<Income> incomes;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "incomeType")
    private Set<Price> prices;
}
