/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travlemaker.Trip;

import com.travlemaker.Attractions.Attraction;
import com.travlemaker.Attractions.Restaurant;
import com.travlemaker.Attractions.Show;
import com.travlemaker.Attractions.Tour;
import java.util.ArrayList;

/**
 *
 * @author hangzi
 */
public class Trip {
    ArrayList<Attraction> plan;
    private String tripId;
    private String targetPrice;
    private String duration;

    public Trip() {
        this.plan = new ArrayList<>();
    }

    public ArrayList<Attraction> getPlan() {
        return plan;
    }

    public void setPlan(ArrayList<Attraction> plan) {
        this.plan = plan;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(String targetPrice) {
        this.targetPrice = targetPrice;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    public Tour newTour(){
        Attraction tour = new Tour();
        plan.add(tour);
        return (Tour) tour;
    }
    
    public Restaurant newRestaurant(){
        Attraction restaurant = new Restaurant();
        plan.add(restaurant);
        return (Restaurant) restaurant;
    }
    
    public Show newShow(){
        Attraction show = new Show();
        plan.add(show);
        return (Show) show;
    }
    
    public void deleteAttraction(Attraction attraction){
        plan.remove(attraction);
    }
}
