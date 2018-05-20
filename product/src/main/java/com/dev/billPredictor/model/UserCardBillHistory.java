package com.dev.billPredictor.model;

import java.util.List;

/**
 * Created by dbatwada on 5/20/18.
 */
public class UserCardBillHistory
{
    private User user;

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public List<CardBillHistory> getCardBillHistory()
    {
        return cardBillHistory;
    }

    public void setCardBillHistory(List<CardBillHistory> cardBillHistory)
    {
        this.cardBillHistory = cardBillHistory;
    }

    private List<CardBillHistory> cardBillHistory;


}
