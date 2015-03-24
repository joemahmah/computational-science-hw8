/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.utility;

import java.util.List;

/**
 *
 * @author mhrcek
 */
public class Mathematics {

    public static List<Double> sort(List<Double> nums) {
        for (int current = 0; current < nums.size(); current++) {
            int indexOfLowest = current;
            for (int target = current; target < nums.size(); target++) {
                if(nums.get(target) < nums.get(indexOfLowest)){
                    indexOfLowest = target;
                }
            }
            double newHighNum = nums.get(current);
            nums.set(current, nums.get(indexOfLowest));
            nums.set(indexOfLowest, newHighNum);
        }
        
        return nums;
    }
    
    public static double calcMedian(List<Double> nums){
        nums = sort(nums);
        
        if(nums.size()%2 == 1){
            int middleIndex = (nums.size()-1)/2;
            return nums.get(middleIndex);
        } else{
            int middleIndexLow = (int) Math.floor((nums.size()-1)/2.0);
            int middleIndexHigh = (int) Math.ceil((nums.size()-1)/2.0);
            double avg =  (nums.get(middleIndexLow) + nums.get(middleIndexHigh))/2;
            return avg;
        }
    }

}
