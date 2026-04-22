/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampus.exceptions;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author dassa
 */
@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Throwable>{

    @Override
    public Response toResponse(Throwable e) {
        
        //Logging the errors that the user cannot see
        e.printStackTrace();
        
        Map<String, Object> errorMessage = new HashMap<>();
        errorMessage.put("Status", 500);
        errorMessage.put("Error", "Internal Server Error");
        errorMessage.put("message", e.getMessage());
        
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(errorMessage)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
}
