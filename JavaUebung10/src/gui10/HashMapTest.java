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

	// Einf�gen der Objekte in die HashMap
 
	map.put(1, "Hamburg");
	map.put(2, "Berlin");
	map.put(18, "M�nchen");

	// Berlin wird durch K�ln ersetzt, da die 
	// 2 schon als Schl�ssel vergeben ist
	map.put(2, "K�ln");
    }
}
