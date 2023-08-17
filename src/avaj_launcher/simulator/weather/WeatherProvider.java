package src.avaj_launcher.simulator.weather;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.plaf.synth.SynthStyle;

public class WeatherProvider {
	private static WeatherProvider instance = null;
	
	private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
	
	private WeatherProvider() {}
	
	public static String getCurrentWeather(Coordinates p_coordinates) {
		if (instance == null) {
			instance = new WeatherProvider();
		}
		long seed = System.currentTimeMillis()
			+ ((p_coordinates.getHeight()
				+ p_coordinates.getLatitude()
				+ p_coordinates.getLongitude()) / 3);
		int random = ThreadLocalRandom.current().nextInt(1, 4 + 1);
		String current = weather[(int) Math.abs((random + seed )% 4)];
		return current;
	}
}
