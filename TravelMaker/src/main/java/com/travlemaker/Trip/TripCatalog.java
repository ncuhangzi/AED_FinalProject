/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travlemaker.Trip;

import java.util.ArrayList;

/**
 *
 * @author hangzi
 */
public class TripCatalog {
    ArrayList<Trip> triplist;

    public TripCatalog() {
        this.triplist = new ArrayList<>();     
    }

    public ArrayList<Trip> getTriplist() {
        return triplist;
    }
    
    public Trip newTrip(){
        Trip trip = new Trip();
        triplist.add(trip);
        return trip;

    }
    public void deleteTrip(Trip trip){
        triplist.remove(trip);
    }
    
    public Trip findTrip(String id){
        
        for (Trip trip: triplist){
            
            if(trip.getTripId().equals(id)) return trip;
        }
        return null;
        }
}
