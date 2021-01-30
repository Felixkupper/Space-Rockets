package clocks;

import SpaceRockets.Collision;
import chars.Player;

public class Asteroid_Collision {
	
	// for Schleife für alle Asteroiden. Try/Catch desweegen, da es sonst passieren kann das der Asteroid komplett gelöscht wird
	public static void collide() {
		
		//Alle Asteroiden und Bullets überprüfen ob sie Kollidieren
		try {
			
			for(int i = 0; i < Asteroid_Creation.asteroids.size(); i++) {
				for(int j = 0; j < BulletCreation.bullets.size(); j++) {
					if(Collision.cBulletAsteroid(BulletCreation.bullets.get(j), Asteroid_Creation.asteroids.get(i))) {
						Asteroid_Creation.asteroids.get(i).setHit(true);
						BulletCreation.bullets.remove(j);
						Asteroid_Creation.asteroids.get(i).setCurrenthealth(Asteroid_Creation.asteroids.get(i)
								.getCurrenthealth() -25);
						
						//überprüfen ob Asteroiden Iridium enthalten
						if(Asteroid_Creation.asteroids.get(i).getCurrenthealth() <= 0) {
							if(Asteroid_Creation.asteroids.get(i).isContainsIridium()){
								if(Player.iridium < 99999999999999L) {
									Player.iridium += Asteroid_Creation.asteroids.get(i).getValue();
								}else {
									Player.iridium = 99999999999999L;
								}
							}
							Asteroid_Creation.asteroids.remove(i);
						}
					}
				}
				
			}
			
		}catch(Exception e) {
			System.out.println("Asteroid collision error");
		}
		try{
			for(int i = 0; i < Asteroid_Creation.asteroids.size(); i++) {
				if(Collision.cPlayerAsteroid(Asteroid_Creation.asteroids.get(i))) {
					Player.isHit = true;
					Player_Hit.start();
					Asteroid_Creation.asteroids.remove(i); //dafür da damit der Asteroid verschwinden nach der Kollision mit Rakete und nicht wiederholt auftaucht und man instant stirbt
					Player.decrementHealth();
					System.out.println(Player.health);
				}
			}
		}catch (Exception e) {
			System.out.println("Player hit error");
		}
	}

}
