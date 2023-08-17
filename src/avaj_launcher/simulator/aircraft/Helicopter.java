package src.avaj_launcher.simulator.aircraft;

import java.io.IOException;

import src.avaj_launcher.simulator.Logger;
import src.avaj_launcher.simulator.weather.Coordinates;

public class Helicopter extends Aircraft {

	public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}
	
	public void updateConditions() throws IOException {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN":
				Logger.log(this.getName() + ": This is hot.");
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude() + 10,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() + 2);
				break;
			case "RAIN":
				Logger.log(this.getName() + ": Watch out, its raining season!");
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude() + 5,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight());
				break;
			case "FOG":
				Logger.log(this.getName() + ": Clearing the fog with my rotor.");
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude() + 1,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight());
				break;
			case "SNOW":
				Logger.log(this.getName() + ": My rotor is going to freeze!");
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
