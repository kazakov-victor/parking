package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.entity.Period;
import edu.pet.vkazakov.mapper.PeriodMapper;
import edu.pet.vkazakov.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@RestController
@PreAuthorize("hasRole('ADMIN') or hasRole('ACCOUNTANT')")
@RequestMapping("/period")
public class PeriodController {

	@Autowired
	PeriodService periodService;
	@Autowired
	PeriodMapper periodMapper;
	

	@RequestMapping("/list")
	public List<Period> listPeriod() {
		List<Period> periods = periodService.findAll();
		return periods;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePeriod(@RequestParam Long id,
							 @RequestParam String dtfrom,
							 @RequestParam String dtto,
							 @RequestParam String tsclose,
							 @RequestParam Boolean closed) {
		Date dtfromIso = null;
		if(dtfrom != null) {dtfromIso =Date.valueOf(dtfrom);}
		Date dttoIso = null;
		if(dtto != null) {dttoIso =Date.valueOf(dtto);}
	/*	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Timestamp tscloseIso = new Timestamp();
		if(id != null || closed == true) {tscloseIso = timestamp}

	 */
		//Period period = new Period(id,dtfromIso,dttoIso,tscloseIso,closed);
	//	periodService.save(period);
		return "redirect:/period/all";
	}
	

	/*
	 * Open or close period for billing
	 */
	@RequestMapping("/toggle/{id}")
	public String togglePeriod(@PathVariable Long id) {
		Period period = periodService.findById(id);
		period.setClosed(!period.isClosed());
		periodService.save(period);
		return "redirect:/period/list";
	}

	/*
	 * Create all new periods for given year
	 */
	@RequestMapping("/create/{year}")
	public String createPeriods(@PathVariable int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);

		for (int i = 0; i < 12; i++) {
			cal.set(Calendar.MONTH, i);
			cal.set(Calendar.DATE, 1);
			Date startDate = new Date(cal.getTimeInMillis());

			if(periodService.findByDtfrom(startDate).isEmpty()){
				cal.add(Calendar.MONTH, 1);
				cal.add(Calendar.DATE, -1);
				Date endDate = new Date(cal.getTimeInMillis());
				Period period = new Period(startDate, endDate,null,true);
				periodService.save(period);
			}
		}


		return "redirect:/period/list";
	}

}


