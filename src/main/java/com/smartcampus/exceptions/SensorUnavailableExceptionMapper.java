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
public class SensorUnavailableExceptionMapper implements ExceptionMapper<SensorUnavailableException>{

    @Override
    public Response toResponse(SensorUnavailableException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", 403);
            errorResponse.put("error", "Forbidden");
            errorResponse.put("message", e.getMessage());
            
            return Response.status(Response.Status.FORBIDDEN)
                    .entity(errorResponse)
                    .type(MediaType.APPLICATION_JSON)
                    .build();
    }
    
}
