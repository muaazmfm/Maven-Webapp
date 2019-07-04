package com.muaz.webapp.functions;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XSDvalidator {
    final static Logger logger = Logger.getLogger(fileWriter.class);
    public boolean validate() {
        logger.info("Validating");
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(new File("/home/muaz/Desktop/MVN/AppA/src/main/Resources/students.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File("/home/muaz/Desktop/MVN/AppA/src/main/Resources/students.xml")));
            return true;
        } catch (SAXException | IOException e) {
            logger.error("There was an error.", e);
            e.printStackTrace();
            return false;
        }
    }

}