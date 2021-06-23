package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.entity.InvoiceTrx;
import edu.pet.vkazakov.service.InvoiceTrxService;
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
@RequestMapping("/invoiceTrxs")
public class InvoiceTrxController {

	@Autowired
	InvoiceTrxService invoiceTrxService;
	

	@RequestMapping("/all")
	public ModelAndView homeInvoiceTrx() {
		List<InvoiceTrx> invoiceTrxs = invoiceTrxService.findAll();
		ModelAndView mav = new ModelAndView("/billing/invoice_trxs.html");
		mav.addObject("invoiceTrxs", invoiceTrxs);
		return mav;
	}

	@RequestMapping("/new")
	public String newInvoiceTrxForm(Map<String, Object> model) {
		InvoiceTrx invoiceTrx = new InvoiceTrx();
		model.put("invoiceTrx", invoiceTrx);
		return "invoiceTrx_new.html";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveInvoiceTrx(@ModelAttribute("invoiceTrx") InvoiceTrx invoiceTrx) {
		invoiceTrxService.save(invoiceTrx);
		return "redirect:/invoiceTrxs/all";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editInvoiceTrxForm(@RequestParam Long id) {
		ModelAndView mav = new ModelAndView("/billing/invoiceTrx_edit.html");
		InvoiceTrx invoiceTrx = invoiceTrxService.findById(id).orElse(new InvoiceTrx());
		mav.addObject("invoiceTrx", invoiceTrx);
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteInvoiceTrxForm(@RequestParam Long id) {
		invoiceTrxService.deleteById(id);
		return "redirect:/invoiceTrxs/all";
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<InvoiceTrx> result = invoiceTrxService.search(keyword);
		ModelAndView mav = new ModelAndView("search_invoiceTrxs.html");
		mav.addObject("result", result);
		return mav;
	}	
}


