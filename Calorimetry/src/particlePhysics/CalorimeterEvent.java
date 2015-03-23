package particlePhysics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CalorimeterEvent implements Serializable {

	private static final long serialVersionUID = -6102468898822038223L;
	private List<Tower> towers = new ArrayList<>();
	
	public void addTower(Tower tower) {
		for (Tower tow : towers) {
			if (tow.getEta() == tower.getEta() && tow.getPhi() == tower.getPhi()) {
				tow.setEnergy(tow.getEnergy() + tower.getEnergy());
				return;
			}
		}
		towers.add(tower);
	}
	
	public List<Tower> getTowers() {
		return towers;
	}
        
        public String toString(){
            String s = "";
            for(Tower t: getTowers()){
                s += t + " | ";
            }
            return s;
        }
}
