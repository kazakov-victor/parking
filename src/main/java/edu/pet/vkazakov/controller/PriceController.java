package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.dto.PriceDTO;
import edu.pet.vkazakov.entity.Price;
import edu.pet.vkazakov.mapper.PriceMapper;
import edu.pet.vkazakov.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/price")
@PreAuthorize("hasRole('ADMIN') or hasRole('ACCOUNTANT')")
public class PriceController {

	@Autowired
	PriceService priceService;
	@Autowired
	PriceMapper priceMapper;
	

	@RequestMapping("/list")
	public List<PriceDTO> homePrice() {
		List<Price> prices = priceService.findAll();
		List<PriceDTO> priceDTOS = priceMapper.toDto(prices);
		return priceDTOS;
	}
		
	@PostMapping("/save")
			public String savePrice(@RequestBody PriceDTO priceDTO) {
			Price price = priceMapper.toEntity(priceDTO);
			priceService.save(price);
			return "redirect:/price/list";
	}

	@RequestMapping("/edit/{id}")
	public PriceDTO editPriceForm(@PathVariable Long id) {
		Price price = priceService.findById(id);
		PriceDTO priceDTO = priceMapper.toDto(price);
		return priceDTO;
	}

	@RequestMapping("/delete/{id}")
	public String deletePrice(@PathVariable Long id) {
		priceService.deleteById(id);
		return "redirect:/prices/all";
	}
	
	@RequestMapping("/search")
	public ModelAndView search(String keyword) {
		List<Price> result = priceService.searchPriceByAmount(keyword);
		ModelAndView mav = new ModelAndView("search_prices.html");
		mav.addObject("result", result);
		return mav;
	}	
}


