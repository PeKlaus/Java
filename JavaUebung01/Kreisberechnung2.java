/* Kreisberechnung2: Für einen Kreis werden der Umfang
 * und der Flächeninhalt berechnet.
 * Der Radius des Kreises wird dem Programm als Parameter
 * übergeben.
 * @date 2011-11-30
 * @author Hans-Peter Habelitz
 */


public class Kreisberechnung2 {
  public static void main(String[] args) {
    double radius = Double.parseDouble(args[0]);
    double umfang = 2.0 * 3.1415926 * radius;
    double flaeche = 3.1415926 * radius * radius;
    System.out.print("Umfang: ");
    System.out.println(umfang);
    System.out.print("Fläche: ");
    System.out.println(flaeche);
  }
}