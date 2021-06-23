package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.dto.ChargeDTO;
import edu.pet.vkazakov.entity.Basis;
import edu.pet.vkazakov.entity.Charge;
import edu.pet.vkazakov.entity.Income;
import edu.pet.vkazakov.entity.Period;
import edu.pet.vkazakov.mapper.ChargeMapper;
import edu.pet.vkazakov.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/charge")
@PreAuthorize("hasRole('ADMIN') or hasRole('ACCOUNTANT')")
public class ChargeController {

	@Autowired
    ChargeService chargeService;
	@Autowired
	ChargeMapper chargeMapper;
	@Autowired
    PeriodService periodService;
	@Autowired
    ContractService contractService;
	@Autowired
    IncomeService incomeService;
	@Autowired
    PriceService priceService;

	@RequestMapping("/list")
	public List<ChargeDTO> homeCharge() {
		List<Charge> charges = chargeService.findAll();
		List<ChargeDTO> chargeDTOS = chargeMapper.toDto(charges);
		return chargeDTOS;
	}

	@RequestMapping("/search")
	public List<ChargeDTO> search(@RequestParam String keyword) {
		List<Charge> result = chargeService.search(keyword);
		List<ChargeDTO> chargeDTOS = chargeMapper.toDto(result);
		return chargeDTOS;
	}
	@RequestMapping("/count")
	public String count(@RequestBody String charge_date) {
		if(charge_date == null || charge_date == ""){return "charge_date incorrect!";}
		Period period = periodService.findByDate(Date.valueOf(charge_date));
		if(!period.isClosed()) {
			Date start = period.getDtfrom();
			Date end = period.getDtto();
			List<Long> contractIds = contractService.searchByPeriod(start, end);
			Basis basis = Basis.МЕСЯЦ;
			for (Long contractId : contractIds) {
				List<Income> incomes = incomeService
						.searchByContractByPeriodByBasis(contractId, start, end, basis.getCode());
				double sum = 0;
				for (Income income : incomes) {
					double price = currentPrice(start, end,
							income.getIncomeType().getIncome_type_id());
					System.out.printf("Price - " + price);
					sum = sum + price * income.getQuantity();

					Charge charge = new Charge(contractId, period.getPeriod_id(),
							income.getIncomeType().getIncome_type_id(),
							income.getQuantity(), price);
					chargeService.save(charge);
				}
			}
		}
		else {return "Period is closed!";}
		return "charge/list";
	}
	public double currentPrice(Date start, Date end, long incomeTypeId) {
		return priceService.searchCurrentPrice(start, end, incomeTypeId);
	}

}


