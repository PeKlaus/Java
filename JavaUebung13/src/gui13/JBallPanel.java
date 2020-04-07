package gui13;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JPanel;
 // erbt von Jpanel und imlementiert Runnable für den Thread
public class JBallPanel extends JPanel implements Runnable {
	
 // Atribute der Klasse >>JBallPanel<<	
	private int x = 0; // >>aktuelle Position des Balls (0=oben/links)
	private Image img; // >>img Variable Image speichert das Bild vom Ball
	private boolean vor = true; //>>vor beschreibt die Richtung (true steht von links nach rechts)
	
 // Überschriebener Konstruktor der Klasse >>JBallPanel<<
	JBallPanel() {
		setBackground(Color.white); // setzt die Hintergrundfarbe auf weiß
		// Den Ball in das img einlesen
		// mit Toolkit...getImage(AbsolutePfad(Benutzer) / + FileName
		img = Toolkit.getDefaultToolkit().getImage("." + File.separator + "Ball.jpg" );
	}
	
 // Überschriebene Methode >>paintComponent<<
	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);
    /* >> DrawImage-Methode von Graphics aufrufen <<
	 *    img, Position x=(0), Mitte des Panels, 
	 *    Breite und Höhe des img ((this) gibt an das es ein ImageObserver-Objekt ist)
	 *    [ ImageObserver überwacht den Aufbereitungsvorgang von Bildern ]
	 *    das gleiche gilt für das lezte (this) */
		g.drawImage(img, x, getHeight() / 2 - img.getHeight(this) / 2 ,
				img.getWidth(this), img.getHeight(this), this);
	}
	
 // >>run()<< Methode zur Aktualisierung der x-Koordinate
	
	/* In der Endlosschleife wird geprüft, ob der rechte oder der linke Rand des Panels erreicht
	 * wurde. Je nachsem wird dann die Bewegungsrichtung umgestellt. Abhängig von der
	 * Bewegungsrichtung wird die x-Koordinate um 2 Pixel erhöt oder verringert. Zur Steuerung
	 * der Geschwindigkeit wird der Thread anschließend für 20 Millisekunden angehalten. Nicht
	 * bei allen Werten ergeben sich flüssige Bewegungsabläufe. Sie sollten mit diesen Werten 
	 * durchaus etwas experimentieren und sich die Auswirkungen ansehen.
	 */
	public void run() {
		while (true) {
			synchronized (this) {
				if (x > getWidth() - img.getWidth(this)) {
					vor = false; // Richtung vom Ball
				} else if (x <= 0) vor = true;
				if (vor) {
					x += 2;
				} else {
					x -= 2;
				}
			}
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				break;
			}
		}
	}

}

/*         >>>>> synchronized <<<<<
 * 
 * Mit synchronyzed können Sie sicherstellen, dass die dadurch geschützten Bereiche zu 
 * einem bestimmten Zeitpunkt nur von einem Thread ausgeführt werden können.Dies
 * gilt aber nur, wenn sie für dasselbe Objekt aufgerufen werden soll. Der erste Thread,
 * der den Zugriff erhalten hat, setzt dabei eine Sperre, die dafür sorgt, das der zweite
 * Thread warten muss, bis die Sperre wieder aufgehoben wurde. Sie müssen immer darauf
 * achten, dass beide(oder auch mehrere) Bereiche, die nicht gleichzeitig bearbeitet 
 * werden dürfen, mit synchronized geschützt sind. 
 */
