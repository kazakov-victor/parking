package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.entity.TrxType;
import edu.pet.vkazakov.service.TrxTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/trxtypes")
public class TrxTypeController {

	@Autowired
	TrxTypeService trxTypeService;
	

	@RequestMapping("/all")
	public ModelAndView homeTrxType() {
		List<TrxType> trxTypes = trxTypeService.findAll();
		ModelAndView mav = new ModelAndView("/billing/trx_types.html");
		mav.addObject("trxTypes", trxTypes);
		return mav;
	}

	@RequestMapping("/new")
	public String newTrxTypeForm(Map<String, Object> model) {
		TrxType trxType = new TrxType();
		model.put("trxType", trxType);
		return "trx_type_new.html";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveTrxType(@ModelAttribute("trxType") TrxType trxType) {
		trxTypeService.save(trxType);
		return "redirect:/trxtypes/all";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editTrxTypeForm(@RequestParam Long id) {
		ModelAndView mav = new ModelAndView("/billing/trxType_edit.html");
		TrxType trxType = trxTypeService.findById(id);
		mav.addObject("trxType", trxType);
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteTrxTypeForm(@RequestParam Long id) {
		trxTypeService.deleteById(id);
		return "redirect:/trxtypes/all";
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<TrxType> result = trxTypeService.search(keyword);
		ModelAndView mav = new ModelAndView("search_trxTypes.html");
		mav.addObject("result", result);
		return mav;
	}	
}


