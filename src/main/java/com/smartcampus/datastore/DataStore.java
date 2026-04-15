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

public class DataStore {
    
    private static Map<String, Room> rooms = new ConcurrentHashMap<>();
    private static Map<String, Sensor> sensors = new ConcurrentHaspMap<>();
    
}
