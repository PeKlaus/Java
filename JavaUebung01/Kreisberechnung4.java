/* Kreisberechnung4: Der Radius für einen Kreis und die Einheit
 * werden über ein Eingabefenster eingegeben. Anschließend
 * werden der Umfang und der Flächeninhalt berechnet.
 * @date 2011-12-30
 * @author Hans-Peter Habelitz
 */

import javax.swing.*;

public class Kreisberechnung4 {
    public static void main(String[] args) {
        String eingabe = JOptionPane.showInputDialog("Geben Sie den Kreisradius ein: ");
        double radius = Double.parseDouble(eingabe);
        eingabe = JOptionPane.showInputDialog("Geben Sie die Einheit ein: ");
        String einheit = eingabe;
        double umfang = 2.0 * 3.1415926 * radius;
        double flaeche = 3.1415926 * radius * radius;
        System.out.print("Umfang: ");
        System.out.print(umfang);
        System.out.println(" " + einheit);
        System.out.print("Fläche: ");
        System.out.print(flaeche);
        System.out.println(" " + einheit + '\u00b2');
    }
}