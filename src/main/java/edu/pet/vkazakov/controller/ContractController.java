package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.dto.ContractDTO;
import edu.pet.vkazakov.dto.IncomeDTO;
import edu.pet.vkazakov.entity.Contract;
import edu.pet.vkazakov.entity.Income;
import edu.pet.vkazakov.mapper.ContractMapper;
import edu.pet.vkazakov.mapper.IncomeMapper;
import edu.pet.vkazakov.service.ContractService;
import edu.pet.vkazakov.service.IncomeService;
import edu.pet.vkazakov.service.IncomeTypeService;
import edu.pet.vkazakov.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contract")
@PreAuthorize("hasRole('ADMIN') or hasRole('ACCOUNTANT')")
public class ContractController {

	@Autowired
	ContractService contractService;
	@Autowired
	PersonService personService;
	@Autowired
	IncomeService incomeService;
	@Autowired
	IncomeTypeService incomeTypeService;
	@Autowired
	private ContractMapper contractMapper;
	@Autowired
	private IncomeMapper incomeMapper;

	@GetMapping("/list")

	public List<ContractDTO> listContractDTO() {
		List<Contract> contracts = contractService.findAll();
		List<ContractDTO> contractDTOS = contractMapper.toDto(contracts);
		return contractDTOS;
	}

	@Transactional
	@RequestMapping("/save")
	public String saveContract(@RequestBody ContractDTO contractDTO)
	{
		Contract contract = contractMapper.toEntity(contractDTO);
		contractService.save(contract);
		System.out.println("Contract.id - " +contract.getContract_id());
		if(contractDTO.getIncomes() != null) {
			List<IncomeDTO> incomeDTOS = contractDTO.getIncomes();
			for(IncomeDTO incomeDTO: incomeDTOS){
				incomeDTO.setContract_id(contract.getContract_id());
			}

			List<Income> incomes = incomeMapper.toEntity(incomeDTOS);

			incomes.forEach(income -> {
				incomeService.save(income);
			});
		}

		return "redirect:/contracts/list";
	}

	@RequestMapping("/edit/{id}")
	public ContractDTO editContractForm(@PathVariable Long id) {
		Contract contract = contractService.findById(id);
		ContractDTO contractDTO = contractMapper.toDto(contract);
		return contractDTO;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteContractForm(@PathVariable Long id) {
		contractService.deleteById(id);
		return "redirect:/contracts/list";
	}
	/*
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Contract> result = contractService.search(keyword);
		ModelAndView mav = new ModelAndView("search_contracts.html");
		mav.addObject("result", result);
		return mav;
	}
*/

}





