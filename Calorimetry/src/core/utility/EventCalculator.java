/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.utility;

import java.util.ArrayList;
import particlePhysics.CalorimeterEvent;
import particlePhysics.Tower;

/**
 *
 * @author mhrcek
 */
public class EventCalculator {
    
    private CalorimeterEvent event;
    private double median;
    
    public EventCalculator(CalorimeterEvent event){
        this.event = event;
        recalculate();
    }
    
    public void recalculate(){
        
        ArrayList<Double> values = new ArrayList<>();

        for(Tower t: event.getTowers()){
            values.add(t.getPhi());
        }
        
        median = Mathematics.calcMedian(values);
        
        
    }
    
}
