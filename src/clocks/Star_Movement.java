package clocks;

import Gui.Gui;

import java.util.ArrayList;

public class Star_Movement {

	public static ArrayList<game.stars> stars = new ArrayList<>();

	// Konstruktor zumn erzeugen verschiedener Sterne in verschiedenen Größen

	public Star_Movement() {
		//100 sterne erzeugen
		for (int i = 0; i < 500; i++) {
			stars.add(new game.stars((int) (Math.random() * Gui.width), (int) (Math.random() * Gui.height),
					(int) (Math.random() * 2) + 1));
		}
	}
	
	public static void move() {
		for (int i = 0; i < 500; i++) {
			stars.get(i).setY(stars.get(i).getY()+1);
			
			//falls die Sterne dann unten ankommen nicht immer If und löschen
			if (stars.get(i).getY() >= Gui.height) {
				stars.get(i).setY(0);
			}
		}
	}
}