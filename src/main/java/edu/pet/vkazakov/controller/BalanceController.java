package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.dto.BalanceDTO;
import edu.pet.vkazakov.entity.Balance;
import edu.pet.vkazakov.mapper.BalanceMapper;
import edu.pet.vkazakov.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/balance")
@PreAuthorize("hasRole('ADMIN') or hasRole('ACCOUNTANT')")
public class BalanceController {

	@Autowired
	BalanceService balanceService;
	@Autowired
	BalanceMapper balanceMapper;

	@RequestMapping("/list")
	public List<BalanceDTO> listBalance() {
		List<Balance> balances = balanceService.findAll();
		List<BalanceDTO> balanceDTOS = balanceMapper.toDto(balances);
		return balanceDTOS;
	}

	@RequestMapping("/search")
	public List<BalanceDTO> search(@RequestParam String keyword) {
		List<Balance> result = balanceService.search(keyword);
		List<BalanceDTO> balanceDTOS = balanceMapper.toDto(result);
		return balanceDTOS;
	}	
}


