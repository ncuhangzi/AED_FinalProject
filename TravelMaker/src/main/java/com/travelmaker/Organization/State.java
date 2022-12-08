/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelmaker.Organization;

import com.travlemaker.Attractions.Attraction;
import java.util.ArrayList;

/**
 *
 * @author hangzi
 */
public class State {
    private String name;
    private String password;
    private String language;
    private String admitted;
    private String imagePath;
    ArrayList<City> cityList;

    public State(String name, String password) {
        this.name = name;
        this.password = password;
        this.cityList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAdmitted() {
        return admitted;
    }

    public void setAdmitted(String admitted) {
        this.admitted = admitted;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public ArrayList<City> getCityList() {
        return cityList;
    }

    public void setCityList(ArrayList<City> cityList) {
        this.cityList = cityList;
    }
    
    public boolean isMatch(String name){
        return this.name.equals(name);
    }
    
    public City newCity(String name, String password){
        City city = new City(name, password);
        cityList.add(city);
        return city;
    }
    public City findCity(String name) {

        for (City c : cityList) {

            if (c.isMatch(name)) {
                return c;
            }
        }
            return null;
    }
    public void deleteCity(City city){
        cityList.remove(city);
    }
    
    public boolean isExisted(String name){
        for (City c : cityList) {

            if (c.isMatch(name)) {
                return true;
            }
        }
            return false;
    }
    
}
