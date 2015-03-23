package particlePhysics;

import java.io.Serializable;

public class Tower implements Serializable {

	private static final long serialVersionUID = 6633798079791877937L;
	private double eta;
	private double phi;
	private double energy;
	private double size; // Towers are all square in eta-phi space
	
	public Tower(double eta, double phi, double energy) {
		this.eta = eta;
		this.phi = phi;
		this.energy = energy;
	}
	
	public double getEta() {
		return eta;
	}
	
	public double getPhi() {
		return phi;
	}
	
	public double getEnergy() {
		return energy;
	}
	
	public void setEnergy(double energy) {
		this.energy = energy;
	}
	
	public double getSize() {
		return size;
	}
        
        public String toString(){
            return getEta() + " " + getPhi() + " " + getEnergy() + " " + getSize();
        }
}
