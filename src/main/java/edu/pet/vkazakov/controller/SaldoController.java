package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.dto.SaldoDTO;
import edu.pet.vkazakov.entity.Saldo;
import edu.pet.vkazakov.mapper.SaldoMapper;
import edu.pet.vkazakov.service.SaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@RestController
@RequestMapping("/saldo")
@PreAuthorize("hasRole('ADMIN') or hasRole('ACCOUNTANT')")
public class SaldoController {
	@Autowired
	SaldoService saldoService;
	@Autowired
	SaldoMapper saldoMapper;

	@GetMapping("/search")
	public ModelAndView search1(@RequestParam(required=false) String selected) {
		int month, year;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		Calendar calendar = new GregorianCalendar();
		if(selected == null) { calendar.set(Calendar.DATE,1); }
		else {
			year = Integer.parseInt(selected.substring(0,4));
			month = Integer.parseInt(selected.substring(5,7));
			calendar.set(year, month-1,1);
		}

		Date sqlDate = new Date(calendar.getTimeInMillis());
		List<Saldo> saldos = saldoService.search(sqlDate);
		ModelAndView mav = new ModelAndView("/billing/billing_monthly.html");
		mav.addObject("saldos", saldos);
		String sqlDateView = dateFormat.format(sqlDate);
		mav.addObject("sqlDate",sqlDateView);
		return mav;
	}

	@PostMapping(path = "/search")

	public ModelAndView searchPost(@RequestParam(required=false) String selected) {
		int month, year;
		Calendar calendar = new GregorianCalendar();
		if(selected == null) {
			calendar.set(Calendar.DATE,1);
		}
		else {
			year = Integer.parseInt(selected.substring(0,4));
			month = Integer.parseInt(selected.substring(5,7));
			calendar.set(year, month-1,1);
		}

		Date sqlDate = new Date(calendar.getTimeInMillis());
		List<Saldo> saldos = saldoService.search(sqlDate);
		ModelAndView mav = new ModelAndView("/billing/billing_monthly.html");
		mav.addObject("saldos", saldos);
		mav.addObject("sqlDate",sqlDate);
		return mav;
	}

	@RequestMapping("/list")
	public List<SaldoDTO> homeSaldo() {
		List<Saldo> saldos = saldoService.findAll();
		List<SaldoDTO> saldoDTOS = saldoMapper.toDto(saldos);
		return saldoDTOS;
	}

}


