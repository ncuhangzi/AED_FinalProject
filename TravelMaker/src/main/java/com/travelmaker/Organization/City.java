/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelmaker.Organization;

import com.travlemaker.Attractions.Attraction;
import com.travlemaker.Attractions.Restaurant;
import com.travlemaker.Attractions.Show;
import com.travlemaker.Attractions.Tour;
import java.util.ArrayList;

/**
 *
 * @author hangzi
 */
public class City {
    private String name;
    private String level;
    private String password;
    private String zipCode;
    private String population;
    private String mayor;
    private String location;
    private String imagePath;
    ArrayList<Attraction> attractionlist;

    public City(String name, String password) {
        this.name = name;
        this.password = password;
        this.attractionlist = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getMayor() {
        return mayor;
    }

    public void setMayor(String mayor) {
        this.mayor = mayor;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public ArrayList<Attraction> getAttractionlist() {
        return attractionlist;
    }

    public void setAttractionlist(ArrayList<Attraction> attractionlist) {
        this.attractionlist = attractionlist;
    }
    
    public Attraction newAttraction(String name, String id, String type){
        Attraction attract = null;
        if(type.equals("Show")){
            attract = new Show(name,id);            
        }else if(type.equals("Tour")){
            attract = new Tour(name,id); 
        }else if(type.equals("Restaurant")){
            attract = new Restaurant(name,id); 
        }
        attractionlist.add(attract);
        return attract;
               
    }
    
    public Attraction findAttraction(String id) {

        for (Attraction a : attractionlist) {

            if (a.isMatch(id)) {
                return a;
            }
        }
            return null;
    }
    
    public void deleteAttraction(Attraction attraction){
        attractionlist.remove(attraction);
    }
    
    public boolean isMatch(String name){
        return this.name.equals(name);
    }
    public boolean isExisted(String id){
        for (Attraction a : attractionlist) {

            if (a.isMatch(id)) {
                return true;
            }
        }
            return false;
    }
    @Override
    public String toString() {
        return name;
    }
    
}
