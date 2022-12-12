/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travlemaker.Attractions;

import java.util.ArrayList;

/**
 *
 * @author hangzi
 */
public class AttractionsCatalog {
    ArrayList<Tour> tourCatalog;
    ArrayList<Restaurant> restaurantCatalog;
    ArrayList<Show> showCatalog;

    public AttractionsCatalog() {
        this.restaurantCatalog = new ArrayList<>();
        this.showCatalog = new ArrayList<>();
        this.tourCatalog = new ArrayList<>();
        
    }

    public ArrayList<Tour> getTourCatalog() {
        return tourCatalog;
    }

    public ArrayList<Restaurant> getRestaurantCatalog() {
        return restaurantCatalog;
    }

    public ArrayList<Show> getShowCatalog() {
        return showCatalog;
    }
   
    public Show newShow(){
        Show show = new Show();
        showCatalog.add(show);
        return show;
    }
    public Show findShow(String id) {

        for (Show s : showCatalog) {

            if (s.isMatch(id)) {
                return s;
            }
        }
            return null;
    }
    public void deleteShow(Show show){
        showCatalog.remove(show);
    } 
    
    public Restaurant newRestaurant(){
        Restaurant restaurant = new Restaurant();
        restaurantCatalog.add(restaurant);
        return restaurant;
    }
    public Restaurant findRestaurant(String id) {

        for (Restaurant r : restaurantCatalog) {

            if (r.isMatch(id)) {
                return r;
            }
        }
            return null; 
    }
    public void deleteRestaurant(Restaurant restaurant){
        restaurantCatalog.remove(restaurant);
    }
    
    public Tour newTour(){
        Tour tour = new Tour();
        tourCatalog.add(tour);
        return tour;
    }
    public Tour findTour(String id) {

        for (Tour t : tourCatalog) {

            if (t.isMatch(id)) {
                return t;
            }
        }
            return null; 
    }
    public void deleteTour(Tour tour){
        tourCatalog.remove(tour);
    } 
}
