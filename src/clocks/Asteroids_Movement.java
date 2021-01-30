package clocks;

import Gui.Gui;

public class Asteroids_Movement {
	
	public static void move() {
		for(int i = 0; i<Asteroid_Creation.asteroids.size(); i++) {
			Asteroid_Creation.asteroids.get(i).setY( Asteroid_Creation.asteroids.get(i).getY() + 
					Asteroid_Creation.asteroids.get(i).getSpeed()); //auf aktuelle Y Position Geschwindigkeit drauf addieren
			
			//Jedes mal wenn Asteroid unten ankomkmt, wird er aus der ArrayListe rausgelsöcht
			if(Asteroid_Creation.asteroids.get(i).getY() > Gui.height) {
				Asteroid_Creation.asteroids.remove(i);
			}
					
		}
	}

}
