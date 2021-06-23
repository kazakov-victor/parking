package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.entity.InvoiceCoverTrx;
import edu.pet.vkazakov.service.InvoiceCoverTrxService;
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
@RequestMapping("/invoiceCoverTrxs")
public class InvoiceCoverTrxController {

	@Autowired
	InvoiceCoverTrxService invoiceCoverTrxService;
	

	@RequestMapping("/all")
	public ModelAndView homeInvoiceCoverTrx() {
		List<InvoiceCoverTrx> invoiceCoverTrxs = invoiceCoverTrxService.findAll();
		ModelAndView mav = new ModelAndView("/billing/invoice_cover_trxs.html");
		mav.addObject("invoiceCoverTrxs", invoiceCoverTrxs);
		return mav;
	}

	@RequestMapping("/new")
	public String newInvoiceCoverTrxForm(Map<String, Object> model) {
		InvoiceCoverTrx invoiceCoverTrx = new InvoiceCoverTrx();
		model.put("invoiceCoverTrx", invoiceCoverTrx);
		return "invoice_cover_trx_new.html";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveInvoiceCoverTrx(@ModelAttribute("invoiceCoverTrx") InvoiceCoverTrx invoiceCoverTrx) {
		invoiceCoverTrxService.save(invoiceCoverTrx);
		return "redirect:/invoiceCoverTrxs/all";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editInvoiceCoverTrxForm(@RequestParam Long id) {
		ModelAndView mav = new ModelAndView("/billing/invoiceCoverTrx_edit.html");
		InvoiceCoverTrx invoiceCoverTrx = invoiceCoverTrxService.findById(id).orElse(new InvoiceCoverTrx());
		mav.addObject("invoiceCoverTrx", invoiceCoverTrx);
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteInvoiceCoverTrxForm(@RequestParam Long id) {
		invoiceCoverTrxService.deleteById(id);
		return "redirect:/invoiceCoverTrxs/all";
	}
	

}


