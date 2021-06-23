package edu.pet.vkazakov.controller;
/*
import edu.pet.entity.Tenant;
import edu.pet.service.TenantService;
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
@RequestMapping("/tenants")
public class TenantController {

	@Autowired
	TenantService tenantService;
	

	@RequestMapping("/all")
	public ModelAndView home() {
		List<Tenant> tenants = tenantService.findAll();
		ModelAndView mav = new ModelAndView("tenants.html");
		mav.addObject("tenants", tenants);
		return mav;
	}

	@RequestMapping("/new")
	public String newTenantForm(Map<String, Object> model) {
		Tenant tenant = new Tenant();
		model.put("tenant", tenant);
		return "tenant_new.html";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveTenant(@ModelAttribute("tenant") Tenant tenant) {
		tenantService.save(tenant);
		return "redirect:/tenants/all";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editTenantForm(@RequestParam Long id) {
		ModelAndView mav = new ModelAndView("tenant_edit.html");
		Tenant tenant = tenantService.findById(id).orElse(new Tenant());
		mav.addObject("tenant", tenant);
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteTenantForm(@RequestParam Long id) {
		tenantService.deleteById(id);
		return "redirect:/tenants/all";
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Tenant> result = tenantService.search(keyword);
		ModelAndView mav = new ModelAndView("search_tenants");
		mav.addObject("result", result);
		return mav;
	}	
}

 */


