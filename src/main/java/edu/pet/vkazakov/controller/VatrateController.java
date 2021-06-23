package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.dto.VatrateDTO;
import edu.pet.vkazakov.entity.Vatrate;
import edu.pet.vkazakov.mapper.VatrateMapper;
import edu.pet.vkazakov.service.VatrateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vatrates")
public class VatrateController {

	@Autowired
	VatrateService vatrateService;
	@Autowired
	VatrateMapper vatrateMapper;
	

	@RequestMapping("/list")
	public List<VatrateDTO> listVatrate() {
		List<Vatrate> vatrates = vatrateService.findAll();
		List<VatrateDTO> vatrateDTOS = vatrateMapper.toDto(vatrates);
		return vatrateDTOS;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveVatrate(@ModelAttribute("vatrate") Vatrate vatrate) {
		vatrateService.save(vatrate);
		return "redirect:/vatrates/all";
	}

	@RequestMapping("/edit/{id}")
	public VatrateDTO editVatrate(@PathVariable Long id) {
		Vatrate vatrate = vatrateService.findById(id);
		VatrateDTO vatrateDTO = vatrateMapper.toDto(vatrate);
		return vatrateDTO;
	}

	@RequestMapping("/delete/{id}")
	public String deleteVatrate(@PathVariable Long id) {
		vatrateService.deleteById(id);
		return "redirect:/vatrates/list";
	}

	@RequestMapping("/search")
	public List<VatrateDTO> search(@RequestParam String keyword) {
		List<Vatrate> result = vatrateService.search(keyword);
		List<VatrateDTO> vatrateDTOS = vatrateMapper.toDto(result);
		return vatrateDTOS;
	}
}


