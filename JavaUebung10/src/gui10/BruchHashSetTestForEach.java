package gui10;

/*
 * Programm BruchHashSetTest
 * 
 * @author Hans-Peter Habelitz
 * @date 2017-07-22
 */

import java.util.HashSet;
import java.util.Iterator;

public class BruchHashSetTestForEach {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Bruch bruch1 = new Bruch(1, 2);
	Bruch bruch2 = new Bruch(3, 4);
	Bruch bruch3 = new Bruch(3, 4);
	HashSet<Bruch> bruchSet = new HashSet<Bruch>();
	bruchSet.add(bruch1);
	bruchSet.add(bruch2);
	bruchSet.add(bruch2); // wird nicht nochmals hinzugefügt, da das identische Objekt
	bruchSet.add(bruch3);
	if (bruch2.equals(bruch3)) {
	    System.out.println("True");
	}
	else {
	    System.out.println("False");
	}
	System.out.println(bruchSet.size());
	bruchSet.forEach((b) -> { System.out.println(b.bruchToString()); System.out.println("Hallo");});
    }

}
