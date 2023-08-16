package src.avaj_launcher.simulator.aircraft;

import src.avaj_launcher.simulator.weather.Coordinates;

public class JetPlane extends Aircraft {

	public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}
	
	public void updateConditions() {
		
	}

	public String getName() {
		return "JetPlane#" + this.name + "(" + this.id + ")";
	}
}
