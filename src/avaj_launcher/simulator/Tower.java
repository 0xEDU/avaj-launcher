package src.avaj_launcher.simulator;

import java.util.ArrayList;
import java.util.List;
import src.avaj_launcher.simulator.aircraft.Flyable;

public class Tower {
	private List<Flyable> observers = new ArrayList<>();
	
	public void register(Flyable p_flyable) {
		observers.add(p_flyable);
	}

	public void unregister(Flyable p_flyable) {
		observers.remove(p_flyable);
	}
	
	protected void conditionChanged() {
	}
}
