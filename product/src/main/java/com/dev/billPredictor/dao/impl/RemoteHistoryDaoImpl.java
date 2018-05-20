package com.dev.billPredictor.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dev.billPredictor.dao.RemoteHistoryDao;
import com.dev.billPredictor.model.remoteBillService.UserCardBillHistoryRemote;

/**
 * Created by dbatwada on 5/20/18.
 */
@Service
public class RemoteHistoryDaoImpl implements RemoteHistoryDao
{
    @Autowired
    RetryTemplate retryTemplate;

    @Value("${com.dev.billPredictor.remoteHistoryServie/userBillHistoryURL}")
    private String USER_CARD_BILL_HISTORY_PATH;


    @Override
    public UserCardBillHistoryRemote getCardBillHistory()
    {
        UserCardBillHistoryRemote userCardBillHistoryRemote = retryTemplate.execute(new RetryCallback<UserCardBillHistoryRemote, RuntimeException>()
        {
            @Override
            public UserCardBillHistoryRemote doWithRetry(RetryContext context)
            {
                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<UserCardBillHistoryRemote> responseEntity = restTemplate.getForEntity
                        (USER_CARD_BILL_HISTORY_PATH, UserCardBillHistoryRemote.class);
                switch (responseEntity.getStatusCodeValue())
                {
                    case 200:
                        return responseEntity.getBody();
                    //TODO customised habdelling as per status code
                    default:
                        throw new RuntimeException("Server Response: " + responseEntity.getStatusCode());

                }

            }
        });
        return userCardBillHistoryRemote;
    }


}
