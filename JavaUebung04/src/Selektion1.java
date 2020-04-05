/* Java-Programm mit if-Anweisung
 *
 * @author Hans-Peter Habelitz
 * @date 2011-12-11
 */

import javax.swing.JOptionPane;

public class Selektion1 {
    public static void main(String[] args) {
	int alter;
	String eingabe;
	eingabe = JOptionPane.showInputDialog("Geben Sie Ihr Alter ein: ");
	alter = Integer.parseInt(eingabe);
	if (alter < 18) {
	    JOptionPane
		    .showMessageDialog(null, "Sorry, noch nicht volljährig!");
	} else {
	    JOptionPane.showMessageDialog(null,
		    "Glückwunsch! Sie sind volljährig!");
	}

    }
}