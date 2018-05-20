package com.dev.billPredictor.model;

/**
 * Created by dbatwada on 5/20/18.
 */
public class CreditCard extends Card
{
    private double limit;

    public double getLimit()
    {
        return limit;
    }

    public void setLimit(double limit)
    {
        this.limit = limit;
    }
}
