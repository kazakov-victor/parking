package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Period;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface PeriodService {
	Period findById(Long id);
	ArrayList<Period> searchOpenPeriod();
	Period findByDate(Date date);
	Optional<Long> findByDtfrom(Date date);
//	List<Period> search(String keyword);
	List<Period> findAll();
	Period save(Period period);
	void deleteById(Long id);
}
