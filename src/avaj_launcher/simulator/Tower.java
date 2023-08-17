package src.avaj_launcher.simulator;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import src.avaj_launcher.simulator.aircraft.Flyable;

public class Tower {
	private List<Flyable> observers = new CopyOnWriteArrayList<>();
	
	public void register(Flyable p_flyable) throws IOException {
		observers.add(p_flyable);
		Logger.log("Tower says: " + p_flyable.getName() + " registered to weather tower.");
	}

	public void unregister(Flyable p_flyable) throws IOException {
		observers.remove(p_flyable);
		Logger.log("Tower says: " + p_flyable.getName() + " unregistered from weather tower.");
	}
	
	protected void conditionChanged() throws IOException {
		for (Flyable f : observers) {
			f.updateConditions();
		}
	}
}
