package src.avaj_launcher.simulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Simulator {
	public static void main(String[] args) throws Exception {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
			System.out.println(bufferedReader.readLine());
			bufferedReader.close();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No input file provided!");
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't open provided file!");
		}
	}
}
