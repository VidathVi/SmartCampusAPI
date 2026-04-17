/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampus.resources;

import java.util.Map;
import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author dassa
 */
@Path("/")
public class DiscoveryResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getApiMetaData(){
        
        
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("Version","v1.0");
        metadata.put("Contact", "w2121281@smartcampus.westminster.ac.uk");
        
        
        Map<String, String> endpoints = new HashMap<>();
        endpoints.put("rooms", "/api/v1/rooms");
        endpoints.put("sensors", "/api/v1/sensrs");
        
        //connecting endpoints to the metadata hasjmap
        metadata.put("resources", endpoints);
        
        return Response.ok(metadata).build();
    }
    
}
