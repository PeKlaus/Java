package gui10;

/*
 * Programm HashMapTest
 * 
 * @author Hans-Peter Habelitz
 * @date 2017-07-22
 */

import java.util.HashMap;

public class HashMapTest {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	    // main-Methode
	HashMap<Integer, String> map = new HashMap<Integer, String>();

	// Einfügen der Objekte in die HashMap
 
	map.put(1, "Hamburg");
	map.put(2, "Berlin");
	map.put(18, "München");

	// Berlin wird durch Köln ersetzt, da die 
	// 2 schon als Schlüssel vergeben ist
	map.put(2, "Köln");
    }
}
