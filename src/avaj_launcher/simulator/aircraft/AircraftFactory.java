package src.avaj_launcher.simulator.aircraft;

import src.avaj_launcher.simulator.weather.Coordinates;

public class AircraftFactory {
	private static AircraftFactory instance = null;
	private static long id = -1;
	
	private AircraftFactory() {}
	
	public static Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		if (instance == null) {
			instance = new AircraftFactory();
		}
		if (p_type.equals("Helicopter")) {
			id++;
			return new Helicopter(id, p_name, p_coordinates);
		}
		if (p_type.equals("JetPlane")) {
			id++;
			return new JetPlane(id, p_name, p_coordinates);
		}
		if (p_type.equals("Baloon")) {
			id++;
			return new Baloon(id, p_name, p_coordinates);
		}
		return null;
	}
}
