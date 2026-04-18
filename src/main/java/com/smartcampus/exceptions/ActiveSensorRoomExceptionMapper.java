/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampus.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author dassa
 */
@Provider
public class ActiveSensorRoomExceptionMapper implements ExceptionMapper<ActiveSensorRoomException>{

    @Override
    public Response toResponse(ActiveSensorRoomException e) {
        
    }
    
}
