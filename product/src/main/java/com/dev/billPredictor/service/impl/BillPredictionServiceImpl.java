package com.dev.billPredictor.service.impl;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.dev.billPredictor.dao.UserCardBillHistoryDao;
import com.dev.billPredictor.model.Bill;
import com.dev.billPredictor.model.UserCardBillHistory;
import com.dev.billPredictor.service.BillPredictionService;
import com.dev.billPredictor.util.DateHelper;

/**
 * Created by dbatwada on 5/20/18.
 */
@Service
public class BillPredictionServiceImpl implements BillPredictionService
{
    @Autowired
    UserCardBillHistoryDao userCardBillHistoryDao;

    @Override
    public Bill getPredictedBill(Date dateHistoryLimit)
    {
        UserCardBillHistory userCardBillHistory = userCardBillHistoryDao.getCardBillHistory(dateHistoryLimit);
        List<Bill> historicalBills = userCardBillHistory.getCardBillHistory().get(0).getBills();
        Bill lastBill = getLastBill(historicalBills);

        double prdictedAmount = getPredictedBillFromHistory(historicalBills);

        Bill predictedBill = new Bill();
        predictedBill.setBillDate(DateHelper.getNextMonthDate(lastBill.getBillDate()));
        predictedBill.setDueDate(DateHelper.getNextMonthDate(lastBill.getDueDate()));
        predictedBill.setBillAmount(prdictedAmount);

        return predictedBill;
    }



    private Bill getLastBill(List<Bill> historicalBills)
    {
        Bill latestBill = historicalBills.stream().max(new Comparator<Bill>()
        {
            @Override
            public int compare(Bill b1, Bill b2)
            {
                return b1.getBillDate().compareTo(b2.getBillDate());
            }
        }).get();

        return latestBill;
    }

    private double getPredictedBillFromHistory(List<Bill> bills)
    {
        double average = getAverageAmount(bills);
        return average;
    }

    private double getAverageAmount(List<Bill> bills)
    {
        double average;
        if (bills.size() == 0)
        {
            average = 0;
        }
        else
        {
            double sum = bills.stream().mapToDouble(Bill::getBillAmount).reduce(0, (b1, b2) -> b1 + b2);
            average = sum / bills.size();
        }
        return average;
    }


}
