package src.avaj_launcher.simulator.aircraft;

import java.io.IOException;

import src.avaj_launcher.simulator.Logger;
import src.avaj_launcher.simulator.weather.Coordinates;

public class Baloon extends Aircraft {

	public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}
	
	public void updateConditions() throws IOException {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN":
				Logger.log(this.getName() + ": Let's enjoy the good weather and take some pics.");
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude() + 2,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() + 4);
				break;
			case "RAIN":
				Logger.log(this.getName() + ": Damn you rain! You messed up my baloon.");
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 5);
				break;
			case "FOG":
				Logger.log(this.getName() + ": We can't see in this thick fog!");
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 3);
				break;
			case "SNOW":
				Logger.log(this.getName() + ": We are going to freeze up here!");
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 15);
				break;
		}
		super.updateConditions();
	}

	public String getName() {
		return "Baloon#" + this.name + "(" + this.id + ")";
	}
}
