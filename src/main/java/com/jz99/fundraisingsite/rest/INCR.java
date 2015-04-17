/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jz99.fundraisingsite.rest;

import com.jz99.fundraisingsite.jpa.Donation;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Joe
 */
@Singleton
@Path("/charity")
public class INCR {
    ArrayList<Donation> donations;
    
    @PostConstruct
    private void init(){
        this.donations = new ArrayList<>();
    }
    
    @GET
    @Path("/{charityId}")
    public Response checkCharityId(){
        return Response.status(Response.Status.OK).build();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/donations")
    public Response storeDonation(Donation donation){
        donations.add(donation);
        return Response.status(Response.Status.OK).build();
    }
}
