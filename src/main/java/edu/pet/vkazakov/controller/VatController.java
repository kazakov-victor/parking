package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.dto.VatDTO;
import edu.pet.vkazakov.entity.Vat;
import edu.pet.vkazakov.mapper.VatMapper;
import edu.pet.vkazakov.service.VatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/vats")
public class VatController {

	@Autowired
	VatService vatService;
	@Autowired
	VatMapper vatMapper;
	

	@RequestMapping("/list")
	public List<VatDTO> homeVat() {
		List<Vat> vats = vatService.findAll();
		List<VatDTO> vatDTOS = vatMapper.toDto(vats);
		return vatDTOS;
	}

	@RequestMapping(value = "/save")
	public String saveVat(@ModelAttribute VatDTO vatDTO) {
		Vat vat = vatMapper.toEntity(vatDTO);
		vatService.save(vat);
		return "redirect:/vats/list";
	}

	@RequestMapping("/edit/{id}")
	public VatDTO editVat(@PathVariable Long id) {
		Vat vat = vatService.findById(id);
		VatDTO vatDTO = vatMapper.toDto(vat);
		return vatDTO;
	}

	@RequestMapping("/delete/{id}")
	public String deleteVatForm(@PathVariable Long id) {
		vatService.deleteById(id);
		return "redirect:/vat/list";
	}
	
	@RequestMapping("/search")
	public List<VatDTO> search(@RequestParam String keyword) {
		List<Vat> result = vatService.search(keyword);
		List<VatDTO> vatDTOS = vatMapper.toDto(result);
		return vatDTOS;
	}	
}


