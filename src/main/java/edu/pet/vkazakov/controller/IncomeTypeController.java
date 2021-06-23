package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.dto.IncomeTypeDTO;
import edu.pet.vkazakov.entity.IncomeType;
import edu.pet.vkazakov.mapper.IncomeTypeMapper;
import edu.pet.vkazakov.service.ContractService;
import edu.pet.vkazakov.service.IncomeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/incometype")
@PreAuthorize("hasRole('ADMIN') or hasRole('ACCOUNTANT')")
public class IncomeTypeController {

	@Autowired
	IncomeTypeService incomeTypeService;
	@Autowired
	ContractService contractService;
	@Autowired
	private IncomeTypeMapper incomeTypeMapper;

	@RequestMapping("/list")
	public List<IncomeTypeDTO> homeIncome() {
		List<IncomeType> incomeTypes = incomeTypeService.findAll();
		List<IncomeTypeDTO> incomeTypeDTOS = incomeTypeMapper
				.toDto(incomeTypes);
		return incomeTypeDTOS;
	}

	@Transactional
	@RequestMapping("/save")
	public String saveIncomeType(@RequestBody IncomeTypeDTO incomeTypeDTO) {
		IncomeType incomeType = incomeTypeMapper.toEntity(incomeTypeDTO);
		incomeTypeService.save(incomeType);
		return "redirect:/incometype/list";
	}
	@Transactional
	@RequestMapping("/edit/{id}")
	public IncomeTypeDTO editIncomeType(@PathVariable Long id) {
		IncomeType incomeType = incomeTypeService.findById(id);
		IncomeTypeDTO incomeTypeDTO = incomeTypeMapper.toDto(incomeType);
		return incomeTypeDTO;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteIncomeForm(@PathVariable Long id) {
		incomeTypeService.deleteById(id);
		return "redirect:/incometypes/all";
	}
}


