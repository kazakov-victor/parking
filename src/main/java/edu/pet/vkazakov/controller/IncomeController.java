package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.dto.IncomeDTO;
import edu.pet.vkazakov.entity.Income;
import edu.pet.vkazakov.mapper.IncomeMapper;
import edu.pet.vkazakov.service.ContractService;
import edu.pet.vkazakov.service.IncomeService;
import edu.pet.vkazakov.service.IncomeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/income")
@PreAuthorize("hasRole('ADMIN') or hasRole('ACCOUNTANT')")
public class IncomeController {

	@Autowired
	IncomeService incomeService;
	@Autowired
	IncomeTypeService incomeTypeService;
	@Autowired
	ContractService contractService;
	@Autowired
	private IncomeMapper incomeMapper;

	@RequestMapping("/list")
	public List<IncomeDTO> listService() {
		List<Income> incomes = incomeService.findAll();
		List<IncomeDTO> incomeDTOS = incomeMapper.toDto(incomes);
		return incomeDTOS;
	}

	@Transactional
	@RequestMapping(value = "/save")
	public String saveIncome(@RequestBody IncomeDTO incomeDTO) {
		Income income = incomeMapper.toEntity(incomeDTO);
		incomeService.save(income);
		return "redirect:/incomes/all";
	}
	
	@RequestMapping("/edit/{id}")
	public IncomeDTO editIncome(@PathVariable Long id) {
		Income income = incomeService.findById(id).orElse(new Income());
		IncomeDTO incomeDTO = incomeMapper.toDto(income);
		return incomeDTO;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteIncomeForm(@PathVariable Long id) {
		incomeService.deleteById(id);
		return "redirect:/income/all";
	}
	
	@RequestMapping("/search")
	public ModelAndView search(String name) {
		Optional<Income> result = incomeService.findByName(name);
		ModelAndView mav = new ModelAndView("search_Incomes.html");
		mav.addObject("result", result);
		return mav;
	}	
}


