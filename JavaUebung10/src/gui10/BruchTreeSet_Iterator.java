package gui10;

/*
 * Programm BruchTreeSet
 * 
 * @author Hans-Peter Habelitz
 * @date 2017-07-22
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class BruchTreeSet_Iterator {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Bruch bruch1 = new Bruch(1, 2);
	Bruch bruch2 = new Bruch(3, 4);
	Bruch bruch3 = new Bruch(3, 4);
	TreeSet<Bruch> bruchSet = new TreeSet<Bruch>();
	bruchSet.add(bruch1);
	bruchSet.add(bruch2);
	bruchSet.add(bruch2); /* wird nicht nochmals hinzugefügt, da das identische Objekt
	                         bereits Bestandteil des TreeSet ist */
	bruchSet.add(bruch3);
	if (bruch2.equals(bruch3)) {
	    System.out.println("True");
	}
	else {
	    System.out.println("False");
	}
	System.out.println(bruchSet.size());
	// Iterator wird angefordert
	Iterator<Bruch> it = bruchSet.iterator();
	// HashSet wird mit dem Iterator durchlaufen
	while (it.hasNext())
	{
	        // Next gibt das aktuelle HashSet-Objekt zurück 
	        // und geht zum nächsten über
	        Bruch b = it.next();
	        // Ausgabe des jeweiligen HashSet-Elementes
	        System.out.println(b.bruchToString());
	}

    }

}
