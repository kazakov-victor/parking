package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.entity.Person;
import edu.pet.vkazakov.service.OwnerService;
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
@RequestMapping("/owners")
public class OwnerController {

	@Autowired
	OwnerService ownerService;
	

	@RequestMapping("/all")
	public ModelAndView homeOwner() {
		List<Person> counterparties = ownerService.findAll();
		ModelAndView mav = new ModelAndView("counterparties.html");
		mav.addObject("owners", counterparties);
		return mav;
	}

	@RequestMapping("/new")
	public String newOwnerForm(Map<String, Object> model) {
		Person person = new Person();
		model.put("owner", person);
		return "person_new.html";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveOwner(@ModelAttribute("owner") Person person) {
		ownerService.save(person);
		return "redirect:/owners/all";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editOwnerForm(@RequestParam Long id) {
		ModelAndView mav = new ModelAndView("person_edit.html");
		Person person = ownerService.findById(id).orElse(new Person());
		mav.addObject("owner", person);
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteOwnerForm(@RequestParam Long id) {
		ownerService.deleteById(id);
		return "redirect:/owners/all";
	}
	
/*	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Person> result = ownerService.search(keyword);
		ModelAndView mav = new ModelAndView("search_owners.html");
		mav.addObject("result", result);
		return mav;
	}	*/
}


