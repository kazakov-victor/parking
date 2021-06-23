package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.entity.Trx;
import edu.pet.vkazakov.service.TrxService;
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
@RequestMapping("/trxs")
public class TrxController {

	@Autowired
	TrxService trxService;
	

	@RequestMapping("/all")
	public ModelAndView homeTrx() {
		List<Trx> trxs = trxService.findAll();
		ModelAndView mav = new ModelAndView("/billing/trxs.html");
		mav.addObject("trxs", trxs);
		return mav;
	}

	@RequestMapping("/new")
	public String newTrxForm(Map<String, Object> model) {
		Trx trx = new Trx();
		model.put("trx", trx);
		return "trx_new.html";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveTrx(@ModelAttribute("trx") Trx trx) {
		trxService.save(trx);
		return "redirect:/trxs/all";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editTrxForm(@RequestParam Long id) {
		ModelAndView mav = new ModelAndView("/billing/trx_edit.html");
		Trx trx = trxService.findById(id);
		mav.addObject("trx", trx);
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteTrxForm(@RequestParam Long id) {
		trxService.deleteById(id);
		return "redirect:/trxs/all";
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Trx> result = trxService.search(keyword);
		ModelAndView mav = new ModelAndView("search_trxs.html");
		mav.addObject("result", result);
		return mav;
	}	
}


