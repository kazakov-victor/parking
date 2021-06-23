package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.dto.DiscountDTO;
import edu.pet.vkazakov.entity.Discount;
import edu.pet.vkazakov.mapper.DiscountMapper;
import edu.pet.vkazakov.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/discounts")
public class DiscountController {

	@Autowired
	DiscountService discountService;
	@Autowired
	DiscountMapper discountMapper;
	

	@RequestMapping("/list")
	public List<DiscountDTO> homeDiscount() {
		List<Discount> discounts = discountService.findAll();
		List<DiscountDTO> discountDTOS = discountMapper.toDto(discounts);
		return discountDTOS;
	}

	@Transactional
	@RequestMapping("/save")
	public String saveDiscount(@RequestBody DiscountDTO discountDTO)
	{
		Discount discount = discountMapper.toEntity(discountDTO);

		discountService.save(discount);

		return "redirect:/discounts/list";
	}

	@RequestMapping("/edit/{id}")
	public DiscountDTO editDiscountForm(@PathVariable Long id) {
		Discount discount = discountService.findById(id);
		DiscountDTO discountDTO = discountMapper.toDto(discount);
		return discountDTO;
	}

	@RequestMapping("/delete/{id}")
	public String deleteDiscountForm(@PathVariable Long id) {
		discountService.deleteById(id);
		return "redirect:/discounts/list";
	}
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Discount> result = discountService.search(keyword);
		ModelAndView mav = new ModelAndView("search_discounts.html");
		mav.addObject("result", result);
		return mav;
	}	
}


