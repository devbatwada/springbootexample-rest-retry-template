package com.dev.billPredictor.dao;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.dev.billPredictor.model.UserCardBillHistory;

/**
 * Created by dbatwada on 5/20/18.
 */
public interface UserCardBillHistoryDao
{
    public UserCardBillHistory getCardBillHistory(Date historyLimit);
}
