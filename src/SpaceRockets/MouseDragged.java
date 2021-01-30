package SpaceRockets;

import chars.Player;
import game.Gamestate;
import game.Gamestate_e;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseDragged implements EventHandler<MouseEvent> {

	@Override
	public void handle(MouseEvent event) {
		
		if(Gamestate.state == Gamestate_e.ingame) {
			Player.isShooting = true;
			Player.move((int)event.getX());
		}
	}
}
