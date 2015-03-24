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
    private double bValue;

    public EventCalculator(CalorimeterEvent event) {
        this.event = event;
        recalculate();
    }

    public void recalculate() {

        ArrayList<Double> values = new ArrayList<>();

        for (Tower t : event.getTowers()) {
            values.add(t.getPhi());
        }

        median = Mathematics.calcMedian(values);

        ArrayList<Double> possibleBValues = new ArrayList<>();
        for (Tower t : event.getTowers()) {
            double energy = t.getEnergy();
            double pi = Math.PI;
            double xpos = t.getPhi();

            //Solves for b
            double b1 = (1 + Math.sqrt(1 - 4 * pi * energy * (pi * xpos * xpos - 2 * pi * xpos * median * energy + pi * median * median * energy))) / (2 * pi * energy);
            double b2 = (1 - Math.sqrt(1 - 4 * pi * energy * (pi * xpos * xpos - 2 * pi * xpos * median * energy + pi * median * median * energy))) / (2 * pi * energy);
            possibleBValues.add(b1);
            possibleBValues.add(b2);
        }

        double highestChi2 = 0;
        double bestB = 0;
        for (Double b : possibleBValues) {
            double chi2 = 0;
            for (Tower t : event.getTowers()) {
                double observed = 1 / Math.PI * b / (Math.pow(t.getPhi() - median, 2) + Math.pow(b, 2));
                double expected = t.getEnergy();
                chi2 += Math.pow(observed - expected,2) / expected;
            }
            if(chi2 > highestChi2){
                highestChi2 = chi2;
                bestB = b;
            }
        }
        
        this.bValue = bestB;

    }

    public double getMedian() {
        return median;
    }

    public double getBValue(){
        return bValue;
    }
    
}
