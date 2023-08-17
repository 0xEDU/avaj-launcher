package src.avaj_launcher.simulator.aircraft;

import java.io.IOException;

import src.avaj_launcher.simulator.Logger;
import src.avaj_launcher.simulator.weather.Coordinates;

public class JetPlane extends Aircraft {

	public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}
	
	public void updateConditions() throws IOException {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN":
				Logger.log(this.getName() + ": It's getting hot here!");
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude() + 10,
					this.coordinates.getHeight() + 2);
				break;
			case "RAIN":
				Logger.log(this.getName() + ": It's raining. Better watch out for lighting.");
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude() + 5,
					this.coordinates.getHeight());
				break;
			case "FOG":
				Logger.log(this.getName() + ": The fog is killing me.");
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude() + 1,
					this.coordinates.getHeight());
				break;
			case "SNOW":
				Logger.log(this.getName() + ": OMG! The winter is coming.");
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 7);
				break;
		}
		super.updateConditions();
	}

	public String getName() {
		return "JetPlane#" + this.name + "(" + this.id + ")";
	}
}
