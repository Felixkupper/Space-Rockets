package SpaceRockets;

import Gui.Gui;
import chars.Player;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseMoved implements EventHandler<MouseEvent> {

	@Override
	public void handle (MouseEvent event) {
		
		Player.move((int) event.getX()); //eigentlich double aber casten zu einjem int
		
		for(int i = 0; i < Gui.buttons.length; i++) {
			if(Collision.cButton(Gui.buttons[i], (int) event.getX(), (int) event.getY())){
				Gui.buttons[i].setHover(true);
			}else {
				Gui.buttons[i].setHover(false);
			}
		}

		for(int i = 0; i < Gui.buttons_angled.length; i++) {
			if(Collision.cButton_angled(Gui.buttons_angled[i], (int) event.getX(), (int) event.getY())){
				Gui.buttons_angled[i].setHover(true);
			}else {
				Gui.buttons_angled[i].setHover(false);
			}
		}
	}
}
