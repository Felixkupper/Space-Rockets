package SpaceRockets;

import chars.Player;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseReleased implements EventHandler<MouseEvent> {

	@Override
	public void handle(MouseEvent event) {
		
		Player.isShooting = false;

	}
}
