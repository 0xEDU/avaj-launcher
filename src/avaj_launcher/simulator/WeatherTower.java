package src.avaj_launcher.simulator;

import src.avaj_launcher.simulator.weather.Coordinates;
import src.avaj_launcher.simulator.weather.WeatherProvider;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates p_coordinates) {
		return WeatherProvider.getCurrentWeather(p_coordinates);
	}

	public void changeWeather() {
		super.conditionChanged();
	}
}
