package com.dev.billPredictor.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.billPredictor.dao.UserCardBillHistoryDao;
import com.dev.billPredictor.model.UserCardBillHistory;
import com.dev.billPredictor.model.remoteBillService.Bill;
import com.dev.billPredictor.model.remoteBillService.UserCardBillHistoryRemote;
import com.dev.billPredictor.util.Mapper;
import com.dev.billPredictor.validator.RemoteServiceResponceValidator;

/**
 * Created by dbatwada on 5/20/18.
 */
@Service
public class UserCardBillHistoryDaoImpl implements UserCardBillHistoryDao
{
    @Autowired
    RemoteHistoryDaoImpl remoteHistoryService;

    @Override
    public UserCardBillHistory getCardBillHistory(Date historyLimit)
    {
        UserCardBillHistoryRemote userCardBillHistoryRemote = remoteHistoryService.getCardBillHistory();
        RemoteServiceResponceValidator.validate(userCardBillHistoryRemote);
        //This logic is in DAO inspite of service layer. It can help if remote service can provides some functionality
        // to filter to reduce load in future.
        removeOlderBills(historyLimit, userCardBillHistoryRemote);

        UserCardBillHistory userCardBillHistory = Mapper.map(userCardBillHistoryRemote);


        return userCardBillHistory;
    }

    private void removeOlderBills(Date historyLimit, UserCardBillHistoryRemote userCardBillHistoryRemote)
    {
        List<Bill> bills = userCardBillHistoryRemote.getBills().stream().filter(bill ->
        {
           return bill.getBillDate().before(historyLimit);
        }).collect(Collectors.toList());
        userCardBillHistoryRemote.setBills(bills);
    }

}
