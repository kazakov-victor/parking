package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.entity.Remain;
import edu.pet.vkazakov.service.RemainService;
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
@RequestMapping("/remains")
public class RemainController {

	@Autowired
	RemainService remainService;

	@RequestMapping("/all")
	public ModelAndView homeRemain() {
		List<Remain> remains = remainService.findAll();
		ModelAndView mav = new ModelAndView("/billing/remains.html");
		mav.addObject("remains", remains);
		return mav;
	}

	@RequestMapping("/new")
	public String newRemainForm(Map<String, Object> model) {
		Remain remain = new Remain();
		model.put("remain", remain);
		return "/billing/remain_new.html";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveRemain(@ModelAttribute("remain") Remain remain) {
		remainService.save(remain);
		return "redirect:/remains/all";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editRemainForm(@RequestParam Long id) {
		ModelAndView mav = new ModelAndView("/billing/remain_edit.html");
		Remain remain = remainService.findById(id).orElse(new Remain());
		mav.addObject("remain", remain);
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteRemainForm(@RequestParam Long id) {
		remainService.deleteById(id);
		return "redirect:/remains/all";
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Remain> remains = remainService.search(keyword);
		ModelAndView mav = new ModelAndView("/billing/remains.html");
		mav.addObject("remains", remains);
		return mav;
	}	
}


