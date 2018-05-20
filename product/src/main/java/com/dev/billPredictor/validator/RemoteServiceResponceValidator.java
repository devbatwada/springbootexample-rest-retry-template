package com.dev.billPredictor.validator;

import com.dev.billPredictor.exception.RemoteServiceManagedException;
import com.dev.billPredictor.model.remoteBillService.UserCardBillHistoryRemote;

/**
 * Created by dbatwada on 5/20/18.
 */
public class RemoteServiceResponceValidator
{

    public static void validate(UserCardBillHistoryRemote userCardBillHistoryRemote)
    {
        if(userCardBillHistoryRemote.getName()==null || userCardBillHistoryRemote.getName().isEmpty())
        {
            throw new RemoteServiceManagedException(RemoteServiceManagedException.UNPROCESSABLE_ENTITY,new Exception());
        }
        //TODO other business validation

    }
}
