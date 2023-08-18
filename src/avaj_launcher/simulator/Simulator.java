package src.avaj_launcher.simulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import src.avaj_launcher.simulator.aircraft.*;
import src.avaj_launcher.simulator.weather.Coordinates;
import src.avaj_launcher.simulator.weather.WeatherTower;

public class Simulator {
	private static WeatherTower weatherTower;
	private static List<Flyable> flyables = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
			String line = bufferedReader.readLine();
			if (line == null) {
				System.out.println("Line is null!");
				System.exit(1);
			}
			int simulationReruns = Integer.parseInt(line);
			if (simulationReruns < 0) {
				System.out.println("Invalid number of repetitions!");
				System.exit(1);
			}
			weatherTower = new WeatherTower();
			while ((line = bufferedReader.readLine()) != null) {
				Coordinates coords = new Coordinates(
					Integer.parseInt(line.split(" ")[2]),
					Integer.parseInt(line.split(" ")[3]),
					Integer.parseInt(line.split(" ")[4]));
				Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1], coords);
				flyables.add(flyable);
			}
			for (Flyable flyable : flyables) {
				flyable.registerTower(weatherTower);
			}
			for (int i = 0; i < simulationReruns; i++) {
				weatherTower.changeWeather();
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't open provided file!");
		} catch (NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid input file!");
		}
	}
}
