package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.dto.PaymentDTO;
import edu.pet.vkazakov.entity.Payment;
import edu.pet.vkazakov.mapper.DateMapper;
import edu.pet.vkazakov.mapper.PaymentMapper;
import edu.pet.vkazakov.service.PaymentService;
import edu.pet.vkazakov.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import static java.lang.String.valueOf;

@RestController
@RequestMapping("/payment")
@PreAuthorize("hasRole('ADMIN') or hasRole('ACCOUNTANT')")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	@Autowired
	PaymentMapper paymentMapper;
	@Autowired
	DateMapper dataMapper;
	@Autowired
	PeriodService periodService;

	@RequestMapping("/list")
	public List<PaymentDTO> homePayment() {
		List<Payment> payments = paymentService.findAll();
		List<PaymentDTO> paymentDTOS = paymentMapper.toDto(payments);
		return paymentDTOS;
	}

	@RequestMapping("/save")
	public String savePayment(@RequestBody PaymentDTO paymentDTO) {
		Payment payment = paymentMapper.toEntity(paymentDTO);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		if (payment.getTscreate() == null) {
			payment.setTscreate(timestamp);
			payment.setTsagent(timestamp);
		}
		Date dateTs = dataMapper.map(valueOf(paymentDTO.getTs()));
		System.out.println("dateTs = " + dateTs);
		System.out.println("findByDate(dateTs) = " + periodService.findByDate(dateTs));
		Long periodID = periodService.findByDate(dateTs).getPeriod_id();
		System.out.println("periodID = " + periodID);
		payment.setTs(timestamp);
		payment.setPeriod_id(periodID);
		//TODO добавить обработку исключений?
		paymentService.save(payment);
		return "redirect:/payments/all";
	}

	@RequestMapping("/edit/{id}")
	public PaymentDTO editPayment(@PathVariable Long id) {
		Payment payment = paymentService.findById(id);
		PaymentDTO paymentDTO = paymentMapper.toDto(payment);
		return paymentDTO;
	}

	@RequestMapping("/delete/{id}")
	public String deletePaymentForm(@PathVariable Long id) {
		paymentService.deleteById(id);
		return "redirect:/payments/all";
	}

	public static boolean equals(String str1, String str2) {
		return str1 == null ? str2 == null : str1.equals(str2);
	}

	/*	@RequestMapping("/search")
		public List<PaymentDTO> search(@RequestParam(name = "keyword", required = false) String keyword) {
			List<Payment> payments;
			if (equals(keyword, "all") || keyword == null) {
				payments = paymentService.findAll();
			} else {
				payments = paymentService.search(keyword);
			}
			List<PaymentDTO> paymentDTOS = paymentMapper.toDto(payments);
			return paymentDTOS;
		}	*/
	@RequestMapping("/select/{period_id}/{contract_id}")
	public double search(@PathVariable Long period_id, @PathVariable Long contract_id) {
		double payments;
		if (period_id == null || contract_id == null) {
			return 0.0;
		} else {
			payments = paymentService.sumByContractIdAndPeriod(contract_id, period_id);
		}

		return payments;
	}
}


