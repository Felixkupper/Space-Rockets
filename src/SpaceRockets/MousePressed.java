package SpaceRockets;

import Gui.Gui;
import chars.Player;
import game.Gamestate;
import game.Gamestate_e;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MousePressed implements EventHandler<MouseEvent> {

	@Override
	public void handle(MouseEvent event) {

		// Button Kollision mit Maus überprüfen also zum anklicken
		switch (Gamestate.state) {
		case ingame:
			Player.isShooting = true;
			break;
		case pause:
			if (Collision.cButton(Gui.buttons[0], (int) event.getX(), (int) event.getY())) {
				Gamestate.state = Gamestate_e.ingame;
			}
			if (Collision.cButton(Gui.buttons[1], (int) event.getX(), (int) event.getY())) {
				Gamestate.state = Gamestate_e.shop;
			}
			if (Collision.cButton(Gui.buttons[2], (int) event.getX(), (int) event.getY())) {
				System.exit(0);
			}
			break;
		case shop:
			break;
		}
	}
}
