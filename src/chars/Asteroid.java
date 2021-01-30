package chars;

import data.CustomMath;
import Gui.Gui;

public class Asteroid {
	
	private int x, y, width, height, health, currenthealth, speed;
	//gucken ob der Asteroid getroffen wurde und ob er Währung enthält
	private boolean isHit = false, containsIridium;
	private int value = 0;
	
	public Asteroid() {
		int ratio = CustomMath.limit((int) (Math.random()* 200)+50, 50, 200); //größe festlegen zwischen 50 und 200 wird er zufällig generiert
		
		//berechnung das jeder 5. Asteroid Währung enthält
		int rnd = (int)(Math.random()*10)+1;
		
		//überprüfen ob die Zahl durch 5 teilbar ist dann ergibt es null
		if (rnd % 5 == 0) {
			containsIridium = true;
		}else {
			containsIridium = false;
		}
		
		width = ratio;
		height = ratio;
		
		// "/" 200 damit die Asteroiden nicht zu viel Leben haben
		health = (width * height) / 350;
		currenthealth = health;
		
		speed = (int)(Math.random()*6)+1; //Schnelligkeit des Asteroiden
		
		x = CustomMath.limit ((int)(Math.random()* Gui.width), 0, Gui.width - width); //breite zuweisen, damit der Asteroid nicht am Bildschirm Rand klebt und "/" 2 damit der Spieler den Rand noch gut erreichen kann
	    //Asteroid somit ein STück höher setzen damit sie ins Bild reingeflogen kommen und nicht an der Decke kleben
		y = -height;
		
		// "/" 400 da er sonst einen zu großen Wert hat
		if(containsIridium) {
			value = (width * height) / 400;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getCurrenthealth() {
		return currenthealth;
	}

	public void setCurrenthealth(int currenthealth) {
		this.currenthealth = currenthealth;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isHit() {
		return isHit;
	}

	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}

	public boolean isContainsIridium() {
		return containsIridium;
	}

	public void setContainsIridium(boolean containsIridium) {
		this.containsIridium = containsIridium;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	

}
