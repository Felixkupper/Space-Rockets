package clocks;

import Gui.Gui;
import game.Gamestate;
import game.Gamestate_e;



public class GameLoop implements Runnable {

	private boolean running = true; // möglichkeit um GameLoop anzuhalten

	@Override
	public void run() {

		long lastTime = System.nanoTime();
		final double FPS = 60.0;
		double ns = 1000000000 / FPS;
		double deltaTime = 0;

		long timer = System.currentTimeMillis();

		while (running) {

			long currentTime = System.nanoTime();
			deltaTime += (currentTime - lastTime) / ns;
			lastTime = currentTime;

			if (deltaTime >= 1) {
				update();
				deltaTime--;
				render();
			}

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
			}
		}

	}

	public void update() {
		if (Gamestate.state == Gamestate_e.ingame) { // Überprüfen ob man im Spiel ist oder im Menü, damit die Sterne
														// sich im Menü nicht bewegen
			Asteroids_Movement.move();
			Asteroid_Collision.collide();
			BulletMovement.move();
			Star_Movement.move();
		}

	}

	public void render() {
		Gui.gc_main.clearRect(0, 0, Gui.width, Gui.height);
		Gui.dm.draw(Gui.gc_main);
	}

}
