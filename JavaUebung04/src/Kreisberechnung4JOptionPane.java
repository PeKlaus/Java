/* Kreisberechnung4JOptionPane: Der Radius für einen Kreis und die Einheit
 * werden über JOptionPane.showInputDialog eingegeben. Anschließend
 * werden der Umfang und der Flächeninhalt berechnet
 * ohne Console
 * @author Hans-Peter Habelitz
 * @date 2011-12-11
 */

import javax.swing.JOptionPane;

public class Kreisberechnung4JOptionPane {
    public static void main(String[] args) {
	String eingabe = JOptionPane
		.showInputDialog("Geben Sie den Kreisradius ein: ");
	double radius = Double.parseDouble(eingabe);
	eingabe = JOptionPane.showInputDialog("Geben Sie die Einheit ein: ");
	String einheit = eingabe;
	double umfang = 2.0 * 3.1415926 * radius;
	double flaeche = 3.1415926 * radius * radius;
	JOptionPane.showMessageDialog(null, "Umfang: " + umfang + " " + einheit
		+ '\n' + " Fläche: " + flaeche + " " + einheit + '\u00b2');
    }
}