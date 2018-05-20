package com.dev.billPredictor.Runner; /**
 * Created by dbatwada on 5/17/18.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.dev.billPredictor.configuration.ApplicationConfiguration;
import com.dev.billPredictor.model.Bill;
import com.dev.billPredictor.service.BillPredictionService;
import com.dev.billPredictor.util.DateHelper;

@RestController
public class Runnner
{
    @Autowired
    BillPredictionService billPredictionService;

    @RequestMapping("/")
    String home()
    {
        return "Hello World!";
    }

    @RequestMapping("/getPredictedBill/{date}")
    Bill getPredictedBill(@PathVariable String date)
    {
        return billPredictionService.getPredictedBill(DateHelper.getDateFromString(date));
    }

}
