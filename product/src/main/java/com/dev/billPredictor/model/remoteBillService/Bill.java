package com.dev.billPredictor.model.remoteBillService;

import java.util.Date;

import com.dev.billPredictor.util.DateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Created by dbatwada on 5/20/18.
 */
public class Bill
{
    @JsonDeserialize(using = DateDeserializer.class)
    Date billDate;

    double billAmount;

    @JsonDeserialize(using = DateDeserializer.class)
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
