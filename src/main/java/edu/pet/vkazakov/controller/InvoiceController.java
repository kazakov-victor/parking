package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.dto.InvoiceDTO;
import edu.pet.vkazakov.entity.Invoice;
import edu.pet.vkazakov.mapper.InvoiceMapper;
import edu.pet.vkazakov.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/invoices")
@PreAuthorize("hasRole('ADMIN') or hasRole('ACCOUNTANT')")
public class InvoiceController {

	@Autowired
	InvoiceService invoiceService;
	@Autowired
	InvoiceMapper invoiceMapper;
	

	@RequestMapping("/list")
	public List<InvoiceDTO> homeInvoice() {
		List<Invoice> invoices = invoiceService.findAll();
		List<InvoiceDTO> invoiceDTOS = invoiceMapper.toDto(invoices);
		return invoiceDTOS;
	}
		
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveInvoice(@ModelAttribute("invoice") Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/invoices/list";
	}

	@RequestMapping("/edit/{id}")
	public InvoiceDTO editInvoiceForm(@PathVariable Long id) {
		Invoice invoice = invoiceService.findById(id);
		InvoiceDTO invoiceDTO = invoiceMapper.toDto(invoice);
		return invoiceDTO;
	}

	@RequestMapping("/delete/{id}")
	public String deleteInvoiceForm(@PathVariable Long id) {
		invoiceService.deleteById(id);
		return "redirect:/invoices/list";
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Invoice> result = invoiceService.search(keyword);
		ModelAndView mav = new ModelAndView("search_invoices.html");
		mav.addObject("result", result);
		return mav;
	}	
}


