package clocks;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import chars.Bullet;
import chars.Player;
import game.Gamestate;
import game.Gamestate_e;

public class BulletCreation {
	
	public static ArrayList<Bullet> bullets = new ArrayList<>();
	public static Timer timer;
	
	public BulletCreation() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if(Gamestate.state == Gamestate_e.ingame) { //Schüsse erst kreieren wenn man im Spiel ist
					if(Player.isShooting) {
						bullets.add(new Bullet(Player.x + Player.width/2-8, Player.y - 30, 15, 50, 20));
					}
				}
			}
			
		}, 200, 200);
		
	}

}
