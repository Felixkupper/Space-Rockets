package chars;

import Gui.Gui;
import game.Gamestate;
import game.Gamestate_e;

public class Player {

	public static int x, y, width = 90, height = 130;
	public static boolean isShooting = false, isHit = false;
	public static int health = 3;
	public static long iridium = 1000000L;

	// Wo soll sich der Player beim Start befinden
	public Player() {
		x = Gui.width / 2 - width / 2;
		y = Gui.height - 200;

	}

	// Move aus führen mit der standard funktion in Java
	public static void move(int xMouse) {

		if (Gamestate.state == Gamestate_e.ingame) {

			if (xMouse >= width && xMouse <= Gui.width - width) {
				x = xMouse - width / 2; // zum zentrieren
			}
		}
	}

	// wenn man getroffen wird, lewben abziehen
	public static void decrementHealth() {
		if (health > 1) {
			health--;

		} else {
			health = 3;
		}
	}

}
