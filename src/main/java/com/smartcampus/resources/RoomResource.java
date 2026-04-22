/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampus.resources;

import com.smartcampus.datastore.DataStore;
import com.smartcampus.exceptions.RoomNotEmptyException;
import com.smartcampus.models.Room;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author dassa
 */
@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomResource {
    
    @GET
    public Response getAllRooms(){
        return Response.ok(DataStore.rooms.values()).build();
    } 
    
    @GET
    @Path("/{roomId}")
    public Response getRoomById(@PathParam("roomId") String roomId){
        return Response.ok(DataStore.rooms.get(roomId)).build();
        
    }
    
    @POST
    public Response createRoom(Room room){
        DataStore.rooms.put(room.getId(), room);
        return Response.status(Response.Status.CREATED).entity(room).build();
    }
    
    @DELETE
    @Path("/{roomId}")
    public Response deleteRoom(@PathParam("roomId") String roomId){
        //fetch room from datastore
        Room room = com.smartcampus.datastore.DataStore.rooms.get(roomId);
        
        
        //check if the room exists
        if(room == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        //check if the room has sensors
        if(!room.getSensorIds().isEmpty()){
            throw new RoomNotEmptyException("Room with active sensors cannot be deleted");
        }
        
        //delet room if it's empty
        com.smartcampus.datastore.DataStore.rooms.remove(roomId);
        return Response.noContent().build();
        
    }
}
