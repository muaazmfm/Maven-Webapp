package com.muaz.webapp.maincode;

import com.muaz.webapp.functions.XSDvalidator;
import com.muaz.webapp.functions.databaseConnection;
import com.muaz.webapp.functions.fileWriter;
import com.muaz.webapp.functions.serializer;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.sql.SQLException;


@Path("/muaz")
public class mainCode {
    @Path("/validate")
    @POST
    @Consumes({"application/xml"})
    @Produces({"application/xml"})
    public Response validation(String Data) {
        fileWriter FR = new fileWriter();
        FR.WriteToFile(Data,"/home/muaz/Desktop/MVN/AppA/src/main/Resources/students.xml");

        XSDvalidator val = new XSDvalidator();
        boolean valid = val.validate();
        if (valid){
            databaseConnection db = new databaseConnection();
            db.connectAndWrite(Data);
            return Response.status(200).entity("It is a valid xml.").build();
        }
        else{
            return Response.status(400).entity("Invalid xml.").build();
        }
    }

    @Path("/serialize")
    @POST
    @Consumes({"application/xml"})
    @Produces({"application/json"})

    public Response serialization(String Data){
        serializer SR = new serializer();
        String serializedData = SR.serialize(Data);

        if (serializedData.equals("ERROR while serializing")){
            return Response.status(400).entity(serializedData).build();
        }
        else{
            return Response.status(200).entity(serializedData).build();
        }
    }
}
