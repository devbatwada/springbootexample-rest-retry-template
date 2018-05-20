package com.dev.billPredictor.exception;

/**
 * Created by dbatwada on 5/20/18.
 */
public class ManagedException extends RuntimeException
{
    public ManagedException(String message, Exception exception)
    {
        super(message,exception);
    }

}
