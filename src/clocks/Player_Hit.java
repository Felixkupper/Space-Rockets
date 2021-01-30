package clocks;

import java.util.Timer;
import java.util.TimerTask;

import chars.Player;

public class Player_Hit {
	
	public static void start() {
		Timer time = new Timer();
		time.schedule(new TimerTask() {
			@Override
			public void run() { //Timer setzen damit nach 100 millisek der Player Hit wieder auf false gesetzt wird
				Player.isHit = false;
				time.cancel();
			}
		}, 100);
	}
}
