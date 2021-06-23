package edu.pet.vkazakov.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
'Обороты (сальдо) за период';
openingbalance IS 'Баланс на начало периода';
debet IS 'Дебетовое сальдо за период';
credit IS 'Кредитовое сальдо за период';
closingbalance IS 'Баланс на конец периода';
 */
@Data
@Entity
public class Saldo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long saldo_id;
	private Long contract_id;
	private Long period_id;
	private Double debet;
	private Double credit;
	private Double openingbalance;
	private Double closingbalance;

	public Saldo(Long contract_id, Long period_id, Double debet, Double credit, Double openingbalance) {
		this.contract_id = contract_id;
		this.period_id = period_id;
		this.debet = debet;
		this.credit = credit;
		this.openingbalance = openingbalance;
		this.closingbalance = openingbalance + debet - credit;
	}

	public Saldo() {

	}
}