/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampus.filter;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author dassa
 */
@Provider
public class ApiLoggingFilter implements ContainerRequestFilter, ContainerResponseFilter{

    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(ApiLoggingFilter.class.getName());
    
    @Override
    public void filter(ContainerRequestContext crqc) throws IOException {
        
        String method = crqc.getMethod();
        String uri = crqc.getUriInfo().getRequestUri().toString();
        
        LOGGER.info("Incoming Requests: " + method + " " + uri);
        
    }

    @Override
    public void filter(ContainerRequestContext crqc, ContainerResponseContext crsc) throws IOException {
        
        int status = crsc.getStatus();
        
        LOGGER.info("Outgoing Response Status: " + status);
    }
    
}
