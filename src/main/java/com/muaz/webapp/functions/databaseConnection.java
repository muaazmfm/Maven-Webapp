package com.muaz.webapp.functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

public class databaseConnection {
    final static Logger logger = Logger.getLogger(databaseConnection.class);

    public void connectAndWrite(String XML) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("There was an error.", e);
            System.out.println("MySQL JDBC Driver not found !!");
            return;
        }

        Statement stmt;
        String id,firstname,lastname,statcd,insertQuery;
        Connection connection = null;
        try {
            retrieveFromXML XMLvalues = new retrieveFromXML();

            id = XMLvalues.getTagValue(XML,"ID");
            firstname = XMLvalues.getTagValue(XML,"FIRST_NAME");
            lastname = XMLvalues.getTagValue(XML,"LAST_NAME");
            statcd = XMLvalues.getTagValue(XML,"STAT_CD");

            insertQuery = "INSERT INTO EMPLOYEE (ID,FIRST_NAME,LAST_NAME,STAT_CD) VALUES (\'"+id+"\',\'"+firstname+"\',\'"+lastname+"\',\'"+statcd+"\');";

            //connection = DriverManager
            //        .getConnection("jdbc:mysql://localhost:3306", "root", "6401430muaz");

            connection = connectionPool.getConnection();

            stmt = connection.createStatement();
            stmt.execute("use db1;");
            stmt.execute(insertQuery);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            return;
        } finally {
            try {
                if (connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

