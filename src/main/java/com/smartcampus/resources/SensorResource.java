/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampus.resources;

import com.smartcampus.datastore.DataStore;
import com.smartcampus.exceptions.LinkedResourceNotFoundException;
import com.smartcampus.models.Sensor;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author dassa
 */

@Path("/sensors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorResource {
    
    @POST
    public Response createSensor(Sensor newSensor){
        
        String roomId = newSensor.getRoomID();
        
        if(!DataStore.rooms.containsKey(roomId)){
            throw new LinkedResourceNotFoundException("The specified room ID does not exist");
        }
        
        DataStore.sensors.put(newSensor.getId(), newSensor);
        return Response.status(Response.Status.CREATED).entity(newSensor).build();
    }
}
