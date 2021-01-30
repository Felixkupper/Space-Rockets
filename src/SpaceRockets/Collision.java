package SpaceRockets;

import Gui.Button;
import Gui.Button_angled;
import chars.Asteroid;
import chars.Bullet;
import chars.Player;

public class Collision {
	
	/*Kollisionsabfrage: //collide(int x, int y, int width, int height, int x1, int y1, int width1, int height1 {
	
	if (x < x1 + width1 && x + width > x1 && y < y1 + height1&& y + height > y1) {
	return true;
}
return false;
}*/
	
	public static boolean cPlayerAsteroid(Asteroid asteroid) {
		return (Player.x + 25 < asteroid.getX() + 15 + asteroid.getWidth() - 30 
				&& Player.x + 25 + Player.width - 50 > asteroid.getX() + 15 
				&& Player.y + 15 < asteroid.getY() + 15 + asteroid.getHeight() - 30 
				&& Player.y + 15 + Player.height - 25 > asteroid.getY() + 15);
				
	}
	
	public static boolean cBulletAsteroid(Bullet bullet, Asteroid asteroid) {
		return (bullet.x < asteroid.getX() + asteroid.getWidth() && bullet.x + bullet.width >
		asteroid.getX() && bullet.y < asteroid.getY() + asteroid.getHeight() && bullet.y + 
		bullet.height > asteroid.getY()); 
		
	}
	
	//Kollision zwischen Maus und Button
	public static boolean cButton(Button button, int x, int y) {
		return (x < button.getX() + button.getWidth() && x > button.getX() && y < button.getY() + button.getHeight() 
		&& y > button.getY());
	}
	
	//ButtonAngled auch zufügen
	public static boolean cButton_angled(Button_angled button, int x, int y) {
		return (x < button.getX1() + button.getWidth() && x > button.getX1() && y < button.getY1() + button.getHeight() 
		&& y > button.getY1());
	}

}
