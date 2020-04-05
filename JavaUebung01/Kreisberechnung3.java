/* Kreisberechnung3: Für einen Kreis 
 * werden der Umfang und der Flächeninhalt berechnet.
 * Der Radius wird beim Programmstart als erster Parameter und
 * die Einheit wird als zweiter Parameter übergeben.
 * @date 2011-12-30
 * @author Hans-Peter Habelitz
*/

public class Kreisberechnung3 {
    public static void main(String[] args) {
        String einheit = args[1];
        double radius = Double.parseDouble(args[0]);
        double umfang = 2.0 * 3.1415926 * radius;
        double inhalt = 3.1415926 * radius * radius;
        System.out.print("Umfang: ");
        System.out.print(umfang);
        System.out.println(" " + einheit);
        System.out.print("Flaeche: ");
        System.out.print(inhalt);
        System.out.println(" " + einheit + '\u00b2');
    }
}
