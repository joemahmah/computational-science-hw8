/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package particlePhysics;

import core.utility.IOHelper;

/**
 *
 * @author mhrcek
 */
public class Boot {

    private IOHelper<CalorimeterData> reader;
    private CalorimeterData data;
    private ClusterVisualizer visualizer;

    public static final String dataFileLocation = "data/calorimeterData.dat";

    public static void main(String[] args) {

        Boot b = new Boot();
        b.level1();

    }

    public Boot() {
        reader = new IOHelper<>();
        data = reader.read(dataFileLocation);
        visualizer = ClusterVisualizer.createVisualizer();
    }

    public void level1() {

        for (CalorimeterEvent e : data.getEvents()) {
            for (Tower t : e.getTowers()) {
                visualizer.addTower(t);
            }
        }
    }
}
