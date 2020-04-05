/* Vokaltest mit if - else
 * Nach der Eingabe eines Zeichens wird geprüft,
 * ob es sich um einen Vokal handelt.
 * Das Ergebnis wird in einem MessageDialog ausgegeben.
 * @author Hans-Peter Habelitz
 * @date 2011-12-11
 */

import javax.swing.JOptionPane;

public class Vokaltest {
    public static void main(String[] args) {
	String eingabe;
	char c;
	boolean istVokal;
	eingabe = JOptionPane
		.showInputDialog("Geben Sie einen Buchstaben ein: ");
	c = eingabe.charAt(0);
	if (c == 'a')
	    istVokal = true;
	else if (c == 'e')
	    istVokal = true;
	else if (c == 'i')
	    istVokal = true;
	else if (c == 'o')
	    istVokal = true;
	else if (c == 'u')
	    istVokal = true;
	else
	    istVokal = false;
	if (istVokal == true) {
	    JOptionPane.showMessageDialog(null, c + " ist ein Vokal!");
	} else {
	    JOptionPane.showMessageDialog(null, c + " ist kein Vokal!");
	}
    }

}