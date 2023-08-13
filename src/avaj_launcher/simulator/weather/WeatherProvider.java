package src.avaj_launcher.simulator.weather;

public class WeatherProvider {
	private static WeatherProvider instance = null;
	
	private String[] weather;
	
	private WeatherProvider() {
	}
	
	public String getCurrentWeather(Coordinates p_coordinates) {
		if (instance == null) {
			instance = new WeatherProvider();
		}
		// Dunno what to do here
		return instance.weather[0];
	}
}
