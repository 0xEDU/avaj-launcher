package src.avaj_launcher.simulator.aircraft;

import java.io.IOException;

import src.avaj_launcher.simulator.weather.WeatherTower;

abstract public class Flyable {
	protected WeatherTower weatherTower;
	
	public abstract void updateConditions() throws IOException;

	public abstract String getName();
	
	public void registerTower(WeatherTower p_tower) throws IOException {
		this.weatherTower = p_tower;
		weatherTower.register(this);
	}
}
