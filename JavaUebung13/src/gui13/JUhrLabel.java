package gui13;

/*
 * Klasse JUhrLabel (Musterlösung zu Kapitel 13 Aufgabe 3)
 * Die Klasse ist von der Klasse JLabel abgeleitet.
 * Die Klasse stellt die aktuelle Uhrzeit als Label dar.
 * Die Uhrzeit wird durch einen eigenen Thread ständig aktualisiert. 
 */

import java.awt.Graphics;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;

public class JUhrLabel extends JLabel implements Runnable {
	
// Konstruktor	
    JUhrLabel() {
	super();
	
// Atribute	
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	String uhrzeit = sdf.format(System.currentTimeMillis());
	setText(uhrzeit);
    }

// Methoden    
    
    // zeichnen der Uhr
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	String uhrzeit = sdf.format(System.currentTimeMillis());
	setText(uhrzeit);
    }

    // Run Methode
    public void run() {
	while (true) {
	    try {
		Thread.sleep(1000);
		repaint();
	    } catch (InterruptedException e) {
		break;
	    }
	}
    }

}
