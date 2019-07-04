package com.muaz.webapp.functions;

import org.apache.log4j.Logger;

public class fileWriter {
    final static Logger logger = Logger.getLogger(fileWriter.class);
    public void WriteToFile(String data, String path) {
        try {
            java.io.FileWriter fw = new java.io.FileWriter(path);
            fw.write(data);
            fw.close();
        } catch (Exception e) {
            logger.error("There was an error.", e);
            System.out.println(e);
        }
        return;
    }
}