package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.dto.TransferDTO;
import edu.pet.vkazakov.entity.Transfer;
import edu.pet.vkazakov.mapper.TransferMapper;
import edu.pet.vkazakov.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/transfers")
public class TransferController {

	@Autowired
	TransferService transferService;
	@Autowired
	TransferMapper transferMapper;
	

	@RequestMapping("/list")
	public List<TransferDTO> homeTransfer() {
		List<Transfer> transfers = transferService.findAll();
		List<TransferDTO> transferDTOS = transferMapper.toDto(transfers);
		return transferDTOS;
	}


	@RequestMapping(value = "/save")
	public String saveTransfer(@ModelAttribute TransferDTO transferDTO) {
		Transfer transfer = transferMapper.toEntity(transferDTO);
		transferService.save(transfer);
		return "redirect:/transfers/list";
	}

	@RequestMapping("/edit/{id}")
	public TransferDTO editTransfer(@PathVariable Long id) {
		Transfer transfer = transferService.findById(id);
		TransferDTO transferDTO = transferMapper.toDto(transfer);
		return transferDTO;
	}

	@RequestMapping("/delete/{id}")
	public String deleteTransferForm(@PathVariable Long id) {
		transferService.deleteById(id);
		return "redirect:/transfer/list";
	}

	@RequestMapping("/search")
	public List<TransferDTO> search(@RequestParam String keyword) {
		List<Transfer> result = transferService.search(keyword);
		List<TransferDTO> transferDTOS = transferMapper.toDto(result);
		return transferDTOS;
	}
}


