package clocks;

import Gui.Gui;
import game.Gamestate;
import game.Gamestate_e;

import java.util.Timer;
import java.util.TimerTask;

//Timer einbauen, Damit sich die Zeichnung nach Sekunden wieder neu Lädt
public class clocksMain {
	Timer timer;

	public clocksMain() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {

				// Fenster wo draufgezeichnet wurde clearen und abfangen mit try/catch
				try {
					Gui.gc_main.clearRect(0, 0, Gui.width, Gui.height);
					Gui.dm.draw(Gui.gc_main);

					if (Gamestate.state == Gamestate_e.ingame) { // Überprüfen ob man im Spiel ist oder im Menü, damit die Sterne sich im Menü nicht berwegen
						Asteroids_Movement.move();
						Asteroid_Collision.collide();
						Star_Movement.move();
					}

				} catch (Exception e) {
					// Gibt diesen Fehler aus statt ganzes Projekt zu beenden, falls nur "hier" was
					// falsch ist
					System.out.println("Main Timer error");
				}

			}

			// 30 millisek zum ausführen und dann führt er sich alle 30 millisek neu aus
		}, 30, 30);

	}

}
