/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampus.resources;

import com.smartcampus.datastore.DataStore;
import com.smartcampus.exceptions.LinkedResourceNotFoundException;
import com.smartcampus.models.Sensor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
public Response createSensor(Sensor newSensor) {
    String roomId = newSensor.getRoomId();
    
    // 1. Verify the room exists 
    if (!DataStore.rooms.containsKey(roomId)) {
        throw new LinkedResourceNotFoundException("The specified room ID does not exist");
    }
    
    // 2. THE FIX: Retrieve the Room and update its sensorIds list [cite: 58]
    // This ensures that when you call room.getSensorIds() later, it's not empty.
    DataStore.rooms.get(roomId).getSensorIds().add(newSensor.getId());
    
    // 3. Register the sensor in the global store [cite: 128]
    DataStore.sensors.put(newSensor.getId(), newSensor);
    
    return Response.status(Response.Status.CREATED).entity(newSensor).build();
}
    
    @GET
    public Response getSensors(@QueryParam("type") String type){
        
        //Fetching all sensors from DataStore
        Collection<Sensor> allSensors = DataStore.sensors.values();
        
        if(type == null || type.trim().isEmpty()){
            return Response.ok(allSensors).build();
        }
        
        List<Sensor> filteredList = new ArrayList<>();
        
        for(Sensor sensor : allSensors){
            if(sensor.getType().equalsIgnoreCase(type)){
                filteredList.add(sensor);
            }
        }
        
        return Response.ok(filteredList).build();
        
    }
    
    @Path("/{sensorId}/readings")
    public SensorReadingResource getSensorReadingResource(@PathParam("sensorId") String sensorId){
        return new SensorReadingResource(sensorId);
    }
}
