package src.avaj_launcher.simulator.weather;

import java.io.IOException;

import src.avaj_launcher.simulator.Tower;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates p_coordinates) {
		return WeatherProvider.getCurrentWeather(p_coordinates);
	}

	public void changeWeather() throws IOException {
		super.conditionChanged();
	}
}
