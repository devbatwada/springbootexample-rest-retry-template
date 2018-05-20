package com.dev.billPredictor.service;

import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.dev.billPredictor.model.Bill;

/**
 * Created by dbatwada on 5/20/18.
 */
@Controller
public interface BillPredictionService
{
    public Bill getPredictedBill(Date dateHistoryLimit);
}
