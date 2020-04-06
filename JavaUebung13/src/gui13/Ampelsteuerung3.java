package gui13;


/*
 * Programm Ampelsteuerung3 (mit eigenem Thread)
 * Das Programm nutzt die Klasse JAmpelPanel. Die Ampel kann manuell
 * in die vier Ampelphasen geschaltet und ausgeschaltet werden.
 * Der Automatikmodus funktioniert, aber das Beenden der Automatik
 * erfolgt offensichtlich nicht ganz korrekt. Es werden noch die Ampelphasen
 * bis zur Gelbphase weiter durchlaufen. Erst danach endet der Schleifendurchlauf. 
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ampelsteuerung3 extends JFrame implements Runnable {

    private JPanel contentPane;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    
    /*
// Zeitliche Richtwerte (ganze Zahlen(int)) für die einzelnen Ampelphasen
    private int rotPhase = 4000;
    private int rotgelbPhase = 1000;
    private int gelbPhase = 1000;
    private int gruenPhase = 4000;
    */
    private int[] phasendauer = {3000, 500, 3000, 500};
    private JAmpelPanel panelAmpel; //Deklaration des panelAmpel
    private JCheckBox chckbxAutomatik;
    Thread t;
    private JRadioButton rdbtnRot;
    private JRadioButton rdbtnRotgelb;
    private JRadioButton rdbtnGruen;
    private JRadioButton rdbtnGelb;
    private JRadioButton rdbtnAus;
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Ampelsteuerung3 frame = new Ampelsteuerung3();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public Ampelsteuerung3() {
    setTitle("Ampelsteuerung3");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 268, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[73.00,grow][grow]", "[grow]"));

 //
	panelAmpel = new JAmpelPanel();
	contentPane.add(panelAmpel, "cell 0 0,grow");
	
	JPanel panelBedienelemente = new JPanel();
	contentPane.add(panelBedienelemente, "cell 1 0,grow");
	panelBedienelemente.setLayout(new MigLayout("", "[125.00,grow]", "[grow][]"));
	
	JPanel panel = new JPanel();
//TitledBorder >> ist unter den properties des Panels zu finden und versieht das Panel mit einem Titel
	panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Handsteuerung", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	panelBedienelemente.add(panel, "cell 0 0,grow");
	panel.setLayout(new MigLayout("", "[87.00]", "[][][][][]"));
	
	rdbtnRot = new JRadioButton("Rot");
	rdbtnRot.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    panelAmpel.setRot();
		}
	});
	buttonGroup.add(rdbtnRot);
	panel.add(rdbtnRot, "cell 0 0");
	
	rdbtnRotgelb = new JRadioButton("RotGelb");
	rdbtnRotgelb.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    panelAmpel.setRotgelb();
		}
	});
	buttonGroup.add(rdbtnRotgelb);
	panel.add(rdbtnRotgelb, "cell 0 1");
	
	rdbtnGruen = new JRadioButton("Gr\u00FCn");
	rdbtnGruen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    panelAmpel.setGruen();
		}
	});
	buttonGroup.add(rdbtnGruen);
	panel.add(rdbtnGruen, "cell 0 2");
	
	rdbtnGelb = new JRadioButton("Gelb");
	rdbtnGelb.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    panelAmpel.setGelb();
		}
	});
	buttonGroup.add(rdbtnGelb);
	panel.add(rdbtnGelb, "cell 0 3");
	
	rdbtnAus = new JRadioButton("Aus");
	rdbtnAus.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    panelAmpel.setAus();
		}
	});
	rdbtnAus.setSelected(true);
	buttonGroup.add(rdbtnAus);
	panel.add(rdbtnAus, "cell 0 4");
	
	chckbxAutomatik = new JCheckBox("Automatik");
	chckbxAutomatik.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) { // << ActionEvent e wird der Methode umschaltAutomatik übergeben
			umschaltenAutomatik(e);
		}
	});
	panelBedienelemente.add(chckbxAutomatik, "cell 0 1,alignx center");
    }
      // Methode zum Starten des Threads die mit dem ActionListener aus chckbxAutomatik ausgeführt wird
		private void umschaltenAutomatik(ActionEvent e) {
		
			       // Boolean Wert ob ausgewählt oder nicht
						Boolean automatikSelected = chckbxAutomatik.isSelected();
				   // Alle Radiobuttens deaktivieren wenn Automatik gewählt ist
						rdbtnRot.setEnabled(!automatikSelected);
						rdbtnRotgelb.setEnabled(!automatikSelected);
						rdbtnGelb.setEnabled(!automatikSelected);
						rdbtnGruen.setEnabled(!automatikSelected);
						rdbtnAus.setEnabled(!automatikSelected);
				   // if / else Schleife für die aktion wenn Automatik aktiviert
						if (chckbxAutomatik.isSelected()) {
							rdbtnRot.setEnabled(false);
							rdbtnRotgelb.setEnabled(false);
							rdbtnGelb.setEnabled(false);
							rdbtnGruen.setEnabled(false);
							rdbtnAus.setEnabled(false);
			//erstellt ein Objekt Thread das mit der run-Methode aus Ampelsteuerung3(this) mit dem namen Automatik
							t = new Thread(this, "Automatik"); 
									t.start(); // Startet den Thread
						} else {
							rdbtnAus.setSelected(true);
							rdbtnRot.setEnabled(true);
							rdbtnRotgelb.setEnabled(true);
							rdbtnGelb.setEnabled(true);
							rdbtnGruen.setEnabled(true);
							rdbtnAus.setEnabled(true);
							panelAmpel.setAus();
						}	
					}

 // Methode für den Thread
	public void run() {
	// Methode die sofort beim beenden der Automatik reagiert
	// da die Phasendauer in einem Array gespeichert sind
		int i = 0;
		while (chckbxAutomatik.isSelected()) {
			try {
				panelAmpel.setPhase(JAmpelPanel.Ampelphase.values()[i]);
				Thread.sleep(phasendauer [i]);
				i++;
				if (i > 3) {
					i = 0;
				} 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

		/*
	// while Schleife zum abarbeiten der einzelnen Ampelphasen
		while (chckbxAutomatik.isSelected()) { 
	    // try / catch zum abfangen von Fehlern
			try {                         
				panelAmpel.setRot();
				Thread.sleep(rotPhase);
				panelAmpel.setRotgelb();
				Thread.sleep(rotgelbPhase);
				panelAmpel.setGruen();
				Thread.sleep(gruenPhase);
				panelAmpel.setGelb();
				Thread.sleep(gelbPhase);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
	*/
}
