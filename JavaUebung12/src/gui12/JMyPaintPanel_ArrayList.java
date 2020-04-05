package gui12;

/*
 * Klasse JMyPaintPanel
 * Die Klasse ist von der Standardkomponente JPanel abgeleitet.
 * Sie dient der Demonstration des Zeichnens in eine Komponente.
 * 
 * @author Hans-Peter Habelitz
 * @date 2013-12-21
 */

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.JPanel;

public class JMyPaintPanel_ArrayList extends JPanel {
    private static final long serialVersionUID = 1L;
    private ArrayList<Zeichenobjekt> figuren;

    public JMyPaintPanel_ArrayList() {
	super();
	figuren = new ArrayList<Zeichenobjekt>();
    }

    public JMyPaintPanel_ArrayList(LayoutManager arg0) {
	super(arg0);
	figuren = new ArrayList<Zeichenobjekt>();
    }

    public JMyPaintPanel_ArrayList(boolean arg0) {
	super(arg0);
	figuren = new ArrayList<Zeichenobjekt>();
    }

    public JMyPaintPanel_ArrayList(LayoutManager arg0, boolean arg1) {
	super(arg0, arg1);
	figuren = new ArrayList<Zeichenobjekt>();
    }

    public void addZeichenobjekt(Zeichenobjekt obj) {
	figuren.add(obj);
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
	for (Zeichenobjekt zo : figuren) {
	    g2d.setColor(zo.getColor());
	    BasicStroke stil = new BasicStroke(zo.getLinienbreite(),
		    BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
	    g2d.setStroke(stil);
	    zo.paint(g2d);
	}
    }

}
