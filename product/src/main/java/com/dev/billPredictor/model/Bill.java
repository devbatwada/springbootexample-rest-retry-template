package com.dev.billPredictor.model;

import java.util.Date;

/**
 * Created by dbatwada on 5/20/18.
 */
public class Bill
{
    Date billDate;
    double billAmount;
    Date dueDate;

    public Date getBillDate()
    {
        return billDate;
    }

    public void setBillDate(Date billDate)
    {
        this.billDate = billDate;
    }

    public double getBillAmount()
    {
        return billAmount;
    }

    public void setBillAmount(double billAmount)
    {
        this.billAmount = billAmount;
    }

    public Date getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(Date dueDate)
    {
        this.dueDate = dueDate;
    }
}
