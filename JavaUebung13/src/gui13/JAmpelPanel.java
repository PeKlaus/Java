package gui13;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JAmpelPanel extends JPanel {
// enum-Wert zur beschreibung der einzelnen Phasen
	enum Ampelphase {AUS, ROT, ROTGELB, GRUEN, GELB};
	private Ampelphase phase = Ampelphase.AUS;
	Color coben, cmitte, cunten;
//Überschriebene paintComponente methode Zeichnet die Ampel in den jeweiligen Phasen
//in der sie sich befindet.
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(new Color(0,80,0));
		switch (phase) {
		case ROT:
			coben = Color.red;
			cmitte = Color.gray;
			cunten = Color.gray;
			break;
		case ROTGELB:
			coben = Color.red;
			cmitte = Color.yellow;
			cunten = Color.gray;
			break;
		case GELB:
			coben = Color.gray;
			cmitte = Color.yellow;
			cunten = Color.gray;
			break;
		case GRUEN:
			coben = Color.gray;
			cmitte = Color.gray;
			cunten = Color.green;
			break;
		case AUS:
			coben = Color.gray;
			cmitte = Color.gray;
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
		g.drawOval(3, 2 * getHeight() /3 + 9, b, h);
	}
// Methoden zum setzen der einzelnen Ampelphasen
	public void setPhase(Ampelphase p) {
		phase = p;
		repaint();
	}
	
	public void setAus() {
		setPhase(Ampelphase.AUS);
	}
	
	public void setRot() {
		setPhase(Ampelphase.ROT);
	}
	
	public void setRotgelb() {
		setPhase(Ampelphase.ROTGELB);
	}
	
	public void setGelb() {
		setPhase(Ampelphase.GELB);
	}
	
	public void setGruen() {
		setPhase(Ampelphase.GRUEN);
	}
}
