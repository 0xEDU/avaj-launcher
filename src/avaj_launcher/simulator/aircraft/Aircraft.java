package src.avaj_launcher.simulator.aircraft;

import src.avaj_launcher.simulator.weather.Coordinates;

public class Aircraft extends Flyable {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	
	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinates;
	}
	
	public void updateConditions() {
		if (this.coordinates.getHeight() > 100) {
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					100);
		}
		if (this.coordinates.getHeight() <= 0) {
			System.out.println(this.getName() + " landing.");
			this.weatherTower.unregister(this);
		}
	}

	public String getName() { return ""; }
}
