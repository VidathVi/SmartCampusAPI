/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampus.datastore;

/**
 *
 * @author dassa
 */
import com.smartcampus.models.Room;
import com.smartcampus.models.Sensor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataStore {
    
    private static Map<String, Room> rooms = new ConcurrentHashMap<>();
    private static Map<String, Sensor> sensors = new ConcurrentHashMap<>();
    
    static{
        //dummy room initialization
        Room dummyRoom = new Room("DumR-001", "Dummy Room", 67);
        
        //dummy sensor initialization
        Sensor dummySensor = new Sensor("DumT-001", "Temperature", "ACTIVE", 24, "DUMR-001");
        
        //adding the sensor IDto room's list
        dummyRoom.getSensorIds().add(dummySensor.getId());
        
        //Store objects in the static maps
        rooms.put(dummyRoom.getId(), dummyRoom);
        sensors.put(dummySensor.getId(), dummySensor);
    }
}
