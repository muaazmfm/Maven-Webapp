package com.muaz.webapp.functions;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;



public class serializer {
    final static Logger logger = Logger.getLogger(serializer.class);
    public String serialize(String xmlpayload) {
        int PRETTY_PRINT_INDENT_FACTOR = 4;

        try {
            JSONObject xmlJSONObj = XML.toJSONObject(xmlpayload);
            String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
            System.out.println(jsonPrettyPrintString);
            return jsonPrettyPrintString;
        } catch (JSONException je) {
            logger.error("There was an error.", je);
            System.out.println(je.toString());
            return "ERROR while serializing";
        }
    }
}