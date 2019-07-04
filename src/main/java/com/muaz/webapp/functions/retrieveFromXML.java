package com.muaz.webapp.functions;

public class retrieveFromXML {
    public String getTagValue(String xml, String tagName) {
        return xml.split("<" + tagName + ">")[1].split("</" + tagName + ">")[0];
    }
}
