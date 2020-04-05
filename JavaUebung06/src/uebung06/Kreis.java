package uebung06;

/*
 * Klasse Kreis
 * @author Hans-Peter Habelitz
 * @date 2013-12-28
 */

public class Kreis extends TeilMitRundung{
	
	Kreis(double r) {
		super(r);
	}

    double getFlaeche() {
	return Math.PI * radius * radius;
    }
    
    double getUmfang() {
	return 2 * Math.PI * radius;
    }
}
