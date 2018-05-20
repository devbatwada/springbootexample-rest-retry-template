package com.dev.billPredictor.exception;

/**
 * Created by dbatwada on 5/20/18.
 */
public class RemoteServiceManagedException extends ManagedException
{
    public static String UNPROCESSABLE_ENTITY = "This responce is not processable";

    public RemoteServiceManagedException(String message, Exception exception)
    {
        super(message, exception);
    }
}
