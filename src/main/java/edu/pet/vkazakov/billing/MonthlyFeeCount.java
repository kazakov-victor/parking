package edu.pet.vkazakov.billing;

import edu.pet.vkazakov.entity.Income;
import edu.pet.vkazakov.entity.Period;
import edu.pet.vkazakov.entity.Saldo;
import edu.pet.vkazakov.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

// Начисления за услуги
@RestController
@PreAuthorize("hasRole('ADMIN')")
//@Component
public class MonthlyFeeCount {

    //private static final Logger log = LoggerFactory.getLogger(MonthlyFeeCount.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    PeriodService periodService;
    @Autowired
    PriceService priceService;
    @Autowired
    ContractService contractService;
    @Autowired
    ChargeService chargeService;
    @Autowired
    TrxService trxService;
    @Autowired
    PaymentService paymentService;
    @Autowired
    IncomeService incomeService;
    @Autowired
    SaldoService saldoService;

    //@Scheduled(cron = "0 0/1 * * * *")
    @RequestMapping("/billing/{id}")
    public String billingCount(@PathVariable Long id) {
        Period period = periodService.findById(id);
        Date start = period.getDtfrom();
        Date end = period.getDtto();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        List<Long> contractIds = contractService.searchByPeriod(start, end);
        for (Long contractId : contractIds) {
            Double debet = paymentService.sumByContractIdAndPeriod(contractId, period.getPeriod_id());
            List<Income> incomes = incomeService.searchByContractByPeriod(contractId,start, end);
            double sum =0;
            for (Income income: incomes){
              //  double price = currentPrice(id, income.getIncomeType().getIncome_type_id());
              //  sum = sum + price * income.getQuantity();
            }
            Saldo saldo = new Saldo(
                    contractId, id, debet, sum, contractService.findById(contractId).getBalance()
            );
            saldoService.save(saldo);
        }
        return "";
    }


      //  long period = openPeriodId();
     /*   if (period > 0) {
            List<Contract> contracts = contractService.findAll();
            long service = 1;
            double price = currentPrice(period, service);
            for (int i = 1; i < contracts.size(); i++) {
                Trx trx = new Trx("45", "d45", period,
                        (long) i, timestamp, timestamp, price, 45L);
                trxService.save(trx);

                Charge charge = new Charge(1L, (long) i, (long) i, period,
                        service, null, null, false, timestamp, timestamp,
                        price, 1L, "test0101" + i * 10);
                chargeService.save(charge);
            }

            Period period1 = periodService.findById(period);
            period1.setClosed(true);
            periodService.save(period1);
        }
        Result result = new Result("good");
        ModelAndView mav = new ModelAndView("/billresult.html");
        mav.addObject("result", result);
        return mav;
    }*/

    /*public long openPeriodId() {
        ArrayList<Period> periods = periodService.searchOpenPeriod();
        switch (periods.size()) {
            case 0:
                System.out.println("All periods are closed!");
                return 0L;
            case 1:
                System.out.println("Working! Made accruals!");
                return periods.get(0).getPeriod_id();
            default:
                System.out.println("WTF! Do something with periods!");
                return -1L;
        }
    }

    public double currentPrice(long periodId, long incomeId) {
        return priceService.searchCurrentPrice(periodId, incomeId);
    }*/
}


