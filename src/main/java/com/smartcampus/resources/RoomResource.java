/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampus.resources;

import com.smartcampus.datastore.DataStore;
import com.smartcampus.models.Room;
import javax.ws.rs.Consumes;
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
}
