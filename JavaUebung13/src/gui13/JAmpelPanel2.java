package gui13;

/*
 * Klasse JAmpelPanel (Musterlösung zu Kapitel 13 Aufgabe 1)
 * Die Klasse dient der Darstellung einer Ampel mit den vier
 * Ampelphasen.
 */

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

// neue Komponente JAmpel2 von JPanel abgeleitet und implementiert Runnable für den Thread
public class JAmpelPanel2 extends JPanel implements Runnable {
	
// Atribute	
    private int[] phasendauer = { 3000, 500, 3000, 500 };// Array für die phasendauer
    int phase = 0; // Ausgangsphase = 0
    Color coben, cmitte, cunten; // Color für die drei Farben der Ampel
    boolean automatik = false; // boolean für automatik = aus
// Konstruktoren
    JAmpelPanel2() {
	super();
    }

    JAmpelPanel2(int r, int rg, int gr, int ge) { //Konstruktor für die Phasen
	super();
	phasendauer[0] = r;
	phasendauer[1] = rg;
	phasendauer[2] = gr;
	phasendauer[3] = ge;
    }
// Ampel zeichnen
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	setBackground(new Color(0, 80, 0));
	switch (phase) {
	case 0:
	    coben = Color.gray;
	    cmitte = Color.gray;
	    cunten = Color.gray;
	    break;
	case 1:
	    coben = Color.red;
	    cmitte = Color.gray;
	    cunten = Color.gray;
	    break;
	case 2:
	    coben = Color.red;
	    cmitte = Color.orange;
	    cunten = Color.gray;
	    break;
	case 3:
	    coben = Color.gray;
	    cmitte = Color.gray;
	    cunten = Color.green;
	    break;
	case 4:
	    coben = Color.gray;
	    cmitte = Color.orange;
	    cunten = Color.gray;
	    break;
	}
	int h = getHeight() / 3 - 12;
	int b = getWidth() - 6;
	g.setColor(coben);
	g.fillOval(3, 3, b, h);
	g.setColor(cmitte);
	g.fillOval(3, getHeight() / 3 + 6, b, h);
	g.setColor(cunten);
	g.fillOval(3, 2 * getHeight() / 3 + 9, b, h);
	g.setColor(Color.black);
	g.drawOval(3, 3, b, h);
	g.drawOval(3, getHeight() / 3 + 6, b, h);
	g.drawOval(3, 2 * getHeight() / 3 + 9, b, h);
    }
// Methoden
    public void setPhase(int i) {
	phase = i;
	repaint();
    }
// Run Methode
    @Override
    public void run() {
	int i = 1;
	while (automatik) {
	    try {
		setPhase(i);
		Thread.sleep(phasendauer[i - 1]);
		i++;
		if (i > 4) {
		    i = 1;
		}
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }

}
