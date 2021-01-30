package clocks;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import chars.Asteroid;
import game.Gamestate;
import game.Gamestate_e;

public class Asteroid_Creation {
	
	public static ArrayList<Asteroid> asteroids = new ArrayList<>();
	
	public static Timer timer;
	//Timer setzen das alle 1,5 sek ein neuer Asteroid erzeugt wird
	public static int delay = 300, period = 300;
	
	public static void start() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if(Gamestate.state == Gamestate_e.ingame) {
					asteroids.add(new Asteroid());
				}
			}
		}, delay, period);
	}

}
