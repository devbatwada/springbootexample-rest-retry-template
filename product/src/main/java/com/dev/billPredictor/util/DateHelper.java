package com.dev.billPredictor.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.dev.billPredictor.exception.BillPredictorManagedException;

/**
 * Created by dbatwada on 5/20/18.
 */
public class DateHelper
{
    public static Date getNextMonthDate(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    public static Date getDateFromString(String date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateObj;
        try
        {
            dateObj = sdf.parse(date);
        }
        catch (ParseException e)
        {
            throw new BillPredictorManagedException("Not a valid date", e);
        }
        return dateObj;

    }
}
