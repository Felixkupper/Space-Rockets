package draw;

import java.text.DecimalFormat;

import Gui.Button;
import Gui.Button_angled;
import Gui.Gui;
import chars.Asteroid;
import chars.Bullet;
import chars.Player;
import clocks.Asteroid_Creation;
import clocks.BulletCreation;
import clocks.Star_Movement;
import game.Gamestate;
import game.Gamestate_e;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class drawMain {

	// Dezimalformat für Zahlen erstllen also nach 3 Zahlen ein Punkt setzen
	private DecimalFormat df = new DecimalFormat("####,####,####");
	private Text text = new Text();

	public void draw(GraphicsContext g) {
		g.setFill(Color.BLACK);
		// Gui.weidth/height damit das ganze Fenster schwarz gefüllt wird
		g.fillRect(0, 0, Gui.width, Gui.height);

		// Sterne zeichnen und größe bestimmen
		g.setFill(Color.WHITE);
		for (int i = 0; i < Star_Movement.stars.size(); i++) {
			g.fillOval(Star_Movement.stars.get(i).getX(), Star_Movement.stars.get(i).getY(),
					Star_Movement.stars.get(i).getSize(), Star_Movement.stars.get(i).getSize());
		}

		// Player Hitbox festlegen und nachschauen, damit die Kollision mit dem Asteroid
		// bei der feinsten Berührung nicht ausgewertet wird
		if (!Player.isHit) {
			g.drawImage(ImageLoader.iplayer, Player.x - 5, Player.y - 5, Player.width + 10, Player.height + 10);

			//g.setStroke(Color.RED);
			//g.strokeRect(Player.x + 25, Player.y + 15, Player.width - 50, Player.height - 25);

		} else {
			g.drawImage(ImageLoader.iplayerHit, Player.x - 5, Player.y - 5, Player.width + 10, Player.height + 10);
		}

		for (Asteroid a : Asteroid_Creation.asteroids) {
			if (a.isContainsIridium()) {
				g.drawImage(ImageLoader.iasteroid_i, a.getX(), a.getY(), a.getWidth(), a.getHeight());
			} else {
				g.drawImage(ImageLoader.iasteroid, a.getX(), a.getY(), a.getWidth(), a.getHeight());
			}

			// wenn Asteroid getroffen wird dann einen Lebensbalken zeichnen. Rot ist Balken
			// und schwarz die outline
			if (a.isHit()) {
				g.setFill(Color.DARKRED);
				g.setFill(Color.BLACK);
				// damit balken nicht im Asteroid sondern etwas darüber ist
				g.fillRect(a.getX() + a.getWidth() / 4, a.getY() - 10, a.getWidth() / 2, 10);

				// Prozenrechnung damit man weis ob man volles oder halbes Leben hat. Von
				// Currenthealth wird immer 1 abgezogen, damit das Leben kleiner wird
				g.setFill(Color.RED);
				g.fillRect(a.getX() + a.getWidth() / 4, a.getY() - 10,
						a.getWidth() / 2 * ((double) a.getCurrenthealth() / (double) a.getHealth()), 10);
			}
			// g.setStroke(Color.BLUE);
			// Werte nur für keinen InstantHit sondern noch etwas Spielraum zwischen Rakete und Asteroid
			// g.strokeRect(a.getX()+ 15, a.getY()+15, a.getWidth()-30, a.getHeight()-30);
		}

		for (Bullet b : BulletCreation.bullets) {
			g.drawImage(ImageLoader.ibullet, b.getX(), b.getY(), b.getWidth(), b.getHeight());
		}

		if (Gamestate.state == Gamestate_e.shop) {
			g.setFill(new Color(0, 0, 0, 5));
			g.fillRect(0, 0, Gui.width, Gui.height);

			g.setStroke(Color.WHITE);
			g.strokeLine(Gui.width / 2, 0, Gui.width / 2, Gui.height);

			g.setFill(Color.WHITE);
			g.setFont(Font.font("Veranda", 20));

			for (Button_angled b : Gui.buttons_angled) {
				if (b.isHover()) {
					g.setFill(new Color(1, 1, 1, 2));
					double[] xpoints = { b.getX1(), b.getX2(), b.getX5(), b.getX1() };
					double[] ypoints = { b.getY1(), b.getY1(), b.getY2(), b.getY2() };

					g.fillPolygon(xpoints, ypoints, 4); // Anzahl der Punkte definieren

					g.setFill(new Color(1, 1, 1, 2));
					double[] xpoints2 = { b.getX3(), b.getX4(), b.getX4(), b.getX6() };
					double[] ypoints2 = { b.getY1(), b.getY1(), b.getY2(), b.getY2() };

					g.fillPolygon(xpoints, ypoints, 4);
				}

				// Links
				g.strokeLine(b.getX1(), b.getY1(), b.getX2(), b.getY1());
				g.strokeLine(b.getX1(), b.getY2(), b.getX5(), b.getY2());

				g.strokeLine(b.getX1(), b.getY1(), b.getX1(), b.getY2());
				g.strokeLine(b.getX2(), b.getY1(), b.getX5(), b.getY2());

				g.setFill(Color.WHITE);
				g.fillText(b.getText(), b.getX1() + 25, b.getY1() + 32);

				// Rechts
				g.strokeLine(b.getX1(), b.getY1(), b.getX2(), b.getY1());
				g.strokeLine(b.getX1(), b.getY2(), b.getX5(), b.getY2());

				g.strokeLine(b.getX1(), b.getY1(), b.getX1(), b.getY2());
				g.strokeLine(b.getX2(), b.getY1(), b.getX5(), b.getY2());

				g.drawImage(ImageLoader.iridium, b.getX3(), b.getY1() + ImageLoader.iridium.getHeight() / 4 + 3, 22,
						22);

			}

			g.setStroke(Color.WHITE);
			g.setFill(new Color(39. / 255., 174. / 255., 96. / 255., 1));
			
			for(int i = 0; i <  Gui.rectangles.length; i++) {
				for(int j = 0; j < Gui.rectangles[i].length; j++ ) {
					
					g.strokeRect(Gui.rectangles[i][j].getX(), Gui.rectangles[i][j].getY(), Gui.rectangles[i][j]
							.getWidth(), Gui.rectangles[i][j].getHeight());
				}
			}
			
			//for()
		}
		
		//oben 2 Balken links und rechts, für Leben Iridium usw.
		g.setStroke(Color.WHITE);
		g.strokeLine(0, 50, 200, 50);
		g.strokeLine(200, 50, 225, 0);

		g.strokeLine(Gui.width - 200, 50, Gui.width, 50);
		g.strokeLine(Gui.width - 225, 0, Gui.width - 200, 50);
		
		//Iridiumanzeige erstellen
		g.drawImage(ImageLoader.iridium, 15, 15, 20, 20);

		g.setFill(Color.WHITE);
		g.setFont(Font.font("Veranda", 25));
		g.fillText(df.format(Player.iridium), 50, 34);
		
		//Healthanzeige erstellen
		g.drawImage(ImageLoader.ihealth, Gui.width - 190, 12, 25, 25);
		
		g.setFill(Color.WHITE);
		g.fillText(df.format(Player.health), Gui.width - 150, 34);
		
		// damit beim pausieren der Hintergrund verblasst
		if (Gamestate.state == Gamestate_e.pause) {
			g.setFill(new Color(0, 0, 0, 0.7));
			g.fillRect(0, 0, Gui.width, Gui.height);

			g.setStroke(Color.GHOSTWHITE);
			g.setFill(Color.ANTIQUEWHITE);

			for (Button b : Gui.buttons) {
				g.strokeRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());

				// Damit die Farbe sich ändert, wenn man über den Button fährt
				g.setFill(new Color(1, 1, 1, 0.2));
				if (b.isHover()) {
					g.fillRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());
				}

				g.setFill(Color.WHITE);

				text.setText(b.getText());
				text.setFont(Font.font("Veranda"));

				g.fillText(b.getText(), b.getX() + b.getWidth() / 2 - text.getLayoutBounds().getWidth() / 2,
						b.getY() + b.getHeight() / 2 + text.getLayoutBounds().getHeight() / 4);

				g.setFill(Color.WHITE);
			}
		}
	}

}
