/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampus.resources;

import com.smartcampus.datastore.DataStore;
import com.smartcampus.exceptions.SensorUnavailableException;
import com.smartcampus.models.Sensor;
import com.smartcampus.models.SensorReading;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author dassa
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorReadingResource {
    
    private String sensorId;

    public SensorReadingResource(String sensorId) {
        this.sensorId = sensorId;
    }
    
    @GET
    public Response getReading(){
        
        //Fetching all the readings of the current sensor
        List<SensorReading> sensorReadings = DataStore.readings.get(this.sensorId);
        
        //make sure the out put is [] instead of null, if sensorReading is empty
        if(sensorReadings == null){
            sensorReadings = new ArrayList<>();
        }
        
        
        return Response.ok(sensorReadings).build();
    }
    
    @POST
    public Response addSensorReading(SensorReading newReading){
        
        Sensor parentSensor = DataStore.sensors.get(this.sensorId);
        
        if("MAINTENANCE".equalsIgnoreCase(parentSensor.getStatus())){
            throw new SensorUnavailableException("Sensor is under maintanance. Cannot accept new readings");
        }
        
        parentSensor.setCurrentValue(newReading.getValue());
        
        
        List<SensorReading> sensorHistory = DataStore.readings.get(this.sensorId);
        if(sensorHistory == null){
            sensorHistory = new ArrayList<>();
            DataStore.readings.put(this.sensorId, sensorHistory);
        }
        
        sensorHistory.add(newReading);
        
        return Response.status(Response.Status.CREATED).entity(newReading).build();
    }
}
