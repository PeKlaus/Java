package gui10;

/*
 * Programm BruchHashSetForEachTest
 * 
 * @author Hans-Peter Habelitz
 * @date 2017-07-22
 */

import java.util.HashSet;
import java.util.function.Consumer;

public class BruchHashSetTest {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Bruch bruch1 = new Bruch(1, 2);
	Bruch bruch2 = new Bruch(3, 4);
	Bruch bruch3 = new Bruch(3, 4);
	HashSet<Bruch> bruchSet = new HashSet<Bruch>();
	bruchSet.add(bruch1);
	bruchSet.add(bruch2);
	bruchSet.add(bruch2); // wird nicht nochmals hinzugefügt, da das identische Objekt bereits HashSet liegt
	bruchSet.add(bruch3);
	if (bruch2.equals(bruch3)) {
	    System.out.println("True");
	}
	else {
	    System.out.println("False");
	}
	System.out.println(bruchSet.size());
/*	bruchSet.forEach(new Consumer<Bruch>() {    // Consumer für den Typ Bruch wird erstellt
	 // die Methode accept definiert, welche Operationen für jedes Element der Collection bruchSet ausgeführt werden
	    public void accept(Bruch element) {	    
		System.out.println(element.bruchToString());
	    }
	});*/
//	bruchSet.forEach((Bruch element) -> System.out.println(element.bruchToString()));
	bruchSet.forEach(element -> System.out.println(element.bruchToString()));
    }

}
