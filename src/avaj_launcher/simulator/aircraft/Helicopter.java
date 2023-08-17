package src.avaj_launcher.simulator.aircraft;

import src.avaj_launcher.simulator.weather.Coordinates;

public class Helicopter extends Aircraft {

	public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}
	
	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN":
				System.out.println(this.getName() + ": This is hot.");
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude() + 10,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() + 2);
				break;
			case "RAIN":
				System.out.println(this.getName() + ": Watch out, its raining season!");
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude() + 5,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight());
				break;
			case "FOG":
				System.out.println(this.getName() + ": Clearing the fog with my rotor.");
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude() + 1,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight());
				break;
			case "SNOW":
				System.out.println(this.getName() + ": My rotor is going to freeze!");
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 12);
				break;
		}
		super.updateConditions();
	}

	public String getName() {
		return "Helicopter#" + this.name + "(" + this.id + ")";
	}
}
