package src.avaj_launcher.simulator.aircraft;

import src.avaj_launcher.simulator.WeatherTower;

abstract public class Flyable {
	protected WeatherTower weatherTower;
	
	public abstract void updateConditions();
	
	public void registerTower(WeatherTower p_tower) {
		this.weatherTower = p_tower;
	}
}
