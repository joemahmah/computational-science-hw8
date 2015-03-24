/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import particlePhysics.Tower;

/**
 *
 * @author mhrcek
 */
public class TowerWriterCSV {
    
    private File file;
    private PrintStream writer;
    
    public TowerWriterCSV(String location) throws FileNotFoundException{
        file = new File(location);
        writer = new PrintStream(file);
        writer.println("Event Index,Tower,Phi,Eta,Energy,Size");
    }
    
    public TowerWriterCSV(File file) throws FileNotFoundException{
        writer = new PrintStream(file);
    }
    
    public void listTower(int eventIndex, int towerIndex, Tower tower){
        writer.println(eventIndex + "," + towerIndex + "," + tower);
    }
    
}
