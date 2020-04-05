package uebung06;

/*
 * Klasse Konto
 * @author Hans-Peter Habelitz
 * @date 2011-12-21
 */

public class Konto {
    private String kontonummer;
    private double kontostand;

    Konto(String knr, double ks) {
	kontonummer = knr;
	kontostand = ks;
    }

    String getKontonummer() {
	return kontonummer;
    }

    double getKontostand() {
	return kontostand;
    }

    void einzahlen(double betrag) {
	kontostand += betrag;
    }

    void auszahlen(double betrag) {
	kontostand -= betrag;
    }
}
