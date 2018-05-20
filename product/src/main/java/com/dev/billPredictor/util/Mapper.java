package com.dev.billPredictor.util;

import java.util.ArrayList;
import java.util.List;

import com.dev.billPredictor.model.Bill;
import com.dev.billPredictor.model.CardBillHistory;
import com.dev.billPredictor.model.CreditCard;
import com.dev.billPredictor.model.User;
import com.dev.billPredictor.model.UserCardBillHistory;
import com.dev.billPredictor.model.remoteBillService.UserCardBillHistoryRemote;

/**
 * Created by dbatwada on 5/20/18.
 */
public class Mapper
{
    public static UserCardBillHistory map(UserCardBillHistoryRemote remoteBillServiceUserCardBillHistoryRemote)
    {
        UserCardBillHistory userCardBillHistory = new UserCardBillHistory();

        User user = new User();
        user.setName(remoteBillServiceUserCardBillHistoryRemote.getName());
        userCardBillHistory.setUser(user);

        CardBillHistory cardBillHistory = new CardBillHistory();

        CreditCard creditCard = new CreditCard();
        creditCard.setType(remoteBillServiceUserCardBillHistoryRemote.getCardType());
        cardBillHistory.setCard(creditCard);

        List<Bill> bills = new ArrayList<>();
        remoteBillServiceUserCardBillHistoryRemote.getBills().forEach(
                remoteBillServiceBill -> {
                    Bill bill = new Bill();
                    bill.setBillAmount(remoteBillServiceBill.getBillAmount());
                    bill.setBillDate(remoteBillServiceBill.getBillDate());
                    bill.setDueDate(remoteBillServiceBill.getDueDate());
                    bills.add(bill);
                }
        );
        cardBillHistory.setBills(bills);

        userCardBillHistory.setCardBillHistory(new ArrayList<CardBillHistory>(){{
            add(cardBillHistory);
        }});


        return userCardBillHistory;
    }
}
