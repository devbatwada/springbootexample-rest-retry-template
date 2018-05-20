package com.dev.billPredictor.dao;

import org.springframework.stereotype.Service;

import com.dev.billPredictor.model.remoteBillService.UserCardBillHistoryRemote;

/**
 * Created by dbatwada on 5/20/18.
 */
public interface RemoteHistoryDao
{
    public UserCardBillHistoryRemote getCardBillHistory();
}
