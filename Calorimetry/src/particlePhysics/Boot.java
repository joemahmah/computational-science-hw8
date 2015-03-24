/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package particlePhysics;

import core.utility.IOHelper;
import core.utility.TowerWriterCSV;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        try {
            Boot b = new Boot();
            b.level1();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Boot.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Boot() {
        reader = new IOHelper<>();
        data = reader.read(dataFileLocation);
        visualizer = ClusterVisualizer.createVisualizer();
    }

    public void level1() throws FileNotFoundException {

        TowerWriterCSV writer = new TowerWriterCSV("data/level1.csv");
        int eventIndex = 0;

        for (CalorimeterEvent e : data.getEvents()) {
            int towerIndex = 0;
            for (Tower t : e.getTowers()) {

                visualizer.addTower(t);
                writer.listTower(eventIndex, towerIndex, t);

                towerIndex++;
            }

            eventIndex++;
        }
    }
}
