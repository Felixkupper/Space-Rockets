package Gui;

import SpaceRockets.KeyPressed;
import SpaceRockets.KeyReleased;
import SpaceRockets.MouseDragged;
import SpaceRockets.MouseMoved;
import SpaceRockets.MousePressed;
import SpaceRockets.MouseReleased;
import draw.drawMain;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Gui {

	public static drawMain dm;

	// Ein Teil der draw funktion, um später zu zeichnen
	public static int width = 1280, height = 720;
	public static GraphicsContext gc_main;

	// Buttons generieren
	public static Button[] buttons = new Button[3];
	public static Button_angled[] buttons_angled = new Button_angled[6]; // 7 Updates hinzufügen

	public static Rectangle[][] rectangles = new Rectangle[buttons_angled.length][5];

	public void Inil() {
		dm = new drawMain();

		//Button Position festlegen
		buttons[0] = new Button(width / 2 - 150, height / 2 - 125, 300, 50);
		buttons[0].setText("Resume");

		buttons[1] = new Button (width / 2 - 150, height / 2 - 25, 300, 50);
		buttons[1].setText("Shop");

		buttons[2] = new Button (width / 2 - 150, height / 2 + 75, 300, 50);
		buttons[2].setText("Exit");

		//Angled Buttons
		for(int i = 1; i < 4; i++) {
			buttons_angled[i-1] = new Button_angled(100, i*150, width / 3, 50);
			buttons_angled[i+2] = new Button_angled(100, i*150, width / 3, 50);

		}
		//Buttons beschrieften
		buttons_angled[0].setText("LaserMax");
		buttons_angled[1].setText("Schieß Schneller Junge");
		buttons_angled[2].setText("Schild Wird Überbewertet");
		buttons_angled[3].setText("Bock auf Iridium?");
		buttons_angled[4].setText("Das wird eine Bombenstimmung");
		buttons_angled[5].setText("Wer ist hier Unsterblich?!");

		boolean temp = false;
		int temp2 = 0;
		for(int i = 0; i < rectangles.length; i++) {
			for (int j = 0; j < rectangles[i].length; j++) {
				if(i % 3 == 0 && i != 0) {
					temp = true;
					temp2 = 0;
				}

				rectangles[i][j] = new Rectangle (100 + j * 20, 210 + temp2 * 150, 10,10);
				
				if(temp) {
					rectangles[i][j] = new Rectangle (100 + width / 2 + j * 20, 210 + temp2 * 150, width, height);
				}

			}
			temp2++;
		}

	}

	public void create(Stage primaryStage) {

		Canvas canvas_main;
		// Eigenschaften Höhe/Breite etc.
		StackPane root = new StackPane();
		int cWidth = width - 10, cHeight = height - 10;

		canvas_main = new Canvas(width, height);
		gc_main = canvas_main.getGraphicsContext2D();
		dm.draw(gc_main);

		// Zum hinzufügen der Root Eigtenschaften width/height
		root.getChildren().add(canvas_main);
		Scene scene = new Scene(root, cWidth, cHeight);

		scene.setOnKeyPressed(new KeyPressed());
		scene.setOnKeyReleased(new KeyReleased());

		scene.setOnMouseMoved(new MouseMoved());
		scene.setOnMouseDragged(new MouseDragged());
		scene.setOnMousePressed(new MousePressed());
		scene.setOnMouseReleased(new MouseReleased());

		primaryStage.setTitle("SpaceRockets by ZeBtRoL");
		primaryStage.setScene(scene);
		// Damit Fenster nicht gezogen werden kann
		primaryStage.setResizable(false);
		// in die Mitte setzen
		primaryStage.centerOnScreen();
		primaryStage.show();

		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			// erst Fenster schließen und dann das Programm, wenn X gedrückt wird
			public void handle(WindowEvent event) {
				Platform.exit();
				System.exit(0);
			}
		});
	}

}
