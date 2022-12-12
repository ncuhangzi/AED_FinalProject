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
public class StateCatalog {
    ArrayList<State> stateList;

    public StateCatalog() {
        this.stateList = new ArrayList<>();
    }
    
    public State newState(String name, String id){
        State state = new State(name, id);
        stateList.add(state);
        return state;
    }
    
    public void deleteState(State state){
        stateList.remove(state);
    }
    
    public State findState(String id){
        for (State s : stateList) {

            if (s.isMatch(id)) {
                return s;
            }
        }
            return null;
    
    }
}
