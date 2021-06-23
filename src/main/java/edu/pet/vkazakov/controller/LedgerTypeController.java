package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.entity.LedgerType;
import edu.pet.vkazakov.service.LedgerTypeService;
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
@RequestMapping("/ledgertypes")
public class LedgerTypeController {

	@Autowired
	LedgerTypeService ledgerTypeService;
	

	@RequestMapping("/all")
	public ModelAndView homeLedgerType() {
		List<LedgerType> ledgertypes = ledgerTypeService.findAll();
		ModelAndView mav = new ModelAndView("/billing/ledgertypes.html");
		mav.addObject("ledgertypes", ledgertypes);
		return mav;
	}

	@RequestMapping("/new")
	public String newLedgerTypeForm(Map<String, Object> model) {
		LedgerType ledgerType = new LedgerType();
		model.put("ledgerType", ledgerType);
		return "ledgertype_new.html";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveLedgerType(@ModelAttribute("ledgerType") LedgerType ledgerType) {
		ledgerTypeService.save(ledgerType);
		return "redirect:/ledgertypes/all";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editLedgerTypeForm(@RequestParam Long id) {
		ModelAndView mav = new ModelAndView("/billing/ledgerType_edit.html");
		LedgerType ledgerType = ledgerTypeService.findById(id).orElse(new LedgerType());
		mav.addObject("ledgerType", ledgerType);
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteLedgerTypeForm(@RequestParam Long id) {
		ledgerTypeService.deleteById(id);
		return "redirect:/ledgerTypes/all";
	}
	
/*	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<LedgerType> result = ledgerTypeService.search(keyword);
		ModelAndView mav = new ModelAndView("search_ledgerTypes.html");
		mav.addObject("result", result);
		return mav;
	}	*/
}


