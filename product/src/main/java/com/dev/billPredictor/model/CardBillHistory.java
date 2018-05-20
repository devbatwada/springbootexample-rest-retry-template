package com.dev.billPredictor.model;

import java.util.List;

/**
 * Created by dbatwada on 5/20/18.
 */
public class CardBillHistory
{
    private Card card;
    private List<Bill> bills;

    public Card getCard()
    {
        return card;
    }

    public void setCard(Card card)
    {
        this.card = card;
    }

    public List<Bill> getBills()
    {
        return bills;
    }

    public void setBills(List<Bill> bills)
    {
        this.bills = bills;
    }
}
