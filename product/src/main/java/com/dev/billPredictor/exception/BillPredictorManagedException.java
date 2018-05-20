package com.dev.billPredictor.exception;

/**
 * Created by dbatwada on 5/20/18.
 */
public class BillPredictorManagedException extends ManagedException
{
    public BillPredictorManagedException(String message, Exception exception)
    {
        super(message, exception);
    }
}
