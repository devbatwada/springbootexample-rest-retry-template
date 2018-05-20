package com.dev.billPredictor.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.dev.billPredictor.exception.BillPredictorManagedException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Created by dbatwada on 5/20/18.
 */
public class DateDeserializer extends JsonDeserializer<Date>
{
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext arg1) throws IOException, JsonProcessingException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        String msDateString = node.asText();

        if (msDateString == null || msDateString.length() == 0)
            return null;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        Date dateObj;
        try
        {
            dateObj = sdf.parse(msDateString);
        }
        catch (ParseException e)
        {
            throw new BillPredictorManagedException("Not a valid date", e);
        }
        return dateObj;
    }
}
