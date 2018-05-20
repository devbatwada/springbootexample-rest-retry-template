package com.dev.billPredictor.model.remoteBillService;

import java.util.List;

/**
 * Created by dbatwada on 5/20/18.
 */
public class UserCardBillHistoryRemote
{
    private String name;
    private double creditLimit;
    private String cardType;
    private List<Bill> bills;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getCreditLimit()
    {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit)
    {
        this.creditLimit = creditLimit;
    }

    public String getCardType()
    {
        return cardType;
    }

    public void setCardType(String cardType)
    {
        this.cardType = cardType;
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
