package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.dto.PaymentTypeDTO;
import edu.pet.vkazakov.entity.PaymentType;
import edu.pet.vkazakov.mapper.PaymentTypeMapper;
import edu.pet.vkazakov.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paymenttype")
@PreAuthorize("hasRole('ADMIN') or hasRole('ACCOUNTANT')")
public class PaymentTypeController {

	@Autowired
	PaymentTypeService paymentTypeService;
	@Autowired
	PaymentTypeMapper paymentTypeMapper;

	@RequestMapping("/list")
	@ResponseBody
	public List<PaymentTypeDTO> listPaymentType() {
		List<PaymentType> paymentTypes = paymentTypeService.findAll();
		List<PaymentTypeDTO> paymentTypeDTOS = paymentTypeMapper.toDto(paymentTypes);
			return paymentTypeDTOS;
	}

	@RequestMapping("/save")
	public String savePaymentType(@RequestBody PaymentTypeDTO paymentTypeDTO) {
		PaymentType paymentType = paymentTypeMapper.toEntity(paymentTypeDTO);
		paymentTypeService.save(paymentType);
		return "redirect:/paymenttypes/list";
	}
	
	@RequestMapping("/edit/{id}")
	public PaymentTypeDTO editPaymentType(@PathVariable Long id) {
		PaymentType paymenttype = paymentTypeService.findById(id);
		PaymentTypeDTO paymentTypeDTO = paymentTypeMapper.toDto(paymenttype);
		return paymentTypeDTO;
	}
	@RequestMapping("/delete/{id}")
	public String deletePaymentType(@PathVariable Long id) {
		paymentTypeService.deleteById(id);
		return "redirect:/paymentTypes/all";
	}

	public static boolean equals(String str1, String str2) {
		return str1 == null ? str2 == null : str1.equals(str2);
	}

	/*@RequestMapping("/search")
	public List<PaymentTypeDTO> search(@RequestParam(name = "keyword", required = false) String keyword) {
		List<PaymentType> paymentTypes;
		if (equals(keyword, "all") || keyword == null) {
			paymentTypes = paymentTypeService.findAll();
		} else {
			paymentTypes = paymentTypeService.search(keyword);
		}
		List<PaymentTypeDTO> paymentTypeDTOS = paymentTypeMapper.toDto(paymentTypes);
		return paymentTypeDTOS;
	}*/
}


