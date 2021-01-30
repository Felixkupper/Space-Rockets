package SpaceRockets;

import Gui.Gui;
import chars.Player;
import clocks.Asteroid_Creation;
import clocks.BulletCreation;
import clocks.Star_Movement;
import clocks.GameLoop;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	Gui g = new Gui();
	
	@Override
	public void start (Stage primaryStage) throws Exception{
		
		g.Inil();
		g.create(primaryStage);
		
		new Player();
		
		
		//Anonymes Objekt aus der Klasse clocks wird erstellt, auf das man nicht mehr zuzgreifen kann 
		//sprich der Konstruktor wird dadurch ausgeführt
		new Thread(new GameLoop()).start();
		
		Asteroid_Creation.start();
		new BulletCreation();
		new Star_Movement();
	}

	
	public static void main (String[] args) {
		launch (args);
	}
}
