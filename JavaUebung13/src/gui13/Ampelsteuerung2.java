package gui13;


/*
 * Programm Ampelsteuerung2 (ohne eigenen Thread, aber mit paintImmediately)
 * Das Programm nutzt die Klasse JAmpelPanel. Die Ampel kann manuell
 * in die vier Ampelphasen geschaltet und ausgeschaltet werden.
 * Die Phasenwechsel werden im Automatikbetrieb sichtbar, aber
 * die Automatik versetzt die Ampelsteuerung in eine Endlosschleife, die
 * aus der Entwicklungsumgebung nur noch über den Stop-Button der Console-
 * View gestoppt werden kann. 
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

public class Ampelsteuerung2 extends JFrame {

    private JPanel contentPane;
    private final ButtonGroup buttonGroup = new ButtonGroup();
// Zeitliche Richtwerte (ganze Zahlen(int)) für die einzelnen Ampelphasen
    private int rotPhase = 4000;
    private int rotgelbPhase = 1000;
    private int gelbPhase = 1000;
    private int gruenPhase = 4000;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Ampelsteuerung2 frame = new Ampelsteuerung2();
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
    public Ampelsteuerung2() {
    	setTitle("Ampelsteuerung");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 268, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[73.00,grow][grow]", "[grow]"));

// Eigens erstelltes JAmpelPanel(JampelPanel Classe) ersetzt ein zuvor erstelltes leeres JPanel das an 
// der Stelle im Frame für die Ampel eingesetzt wurde.
// >>JPanel panelAmpel = new JPanel();<<
	JAmpelPanel panelAmpel = new JAmpelPanel();
	contentPane.add(panelAmpel, "cell 0 0,grow");
	
	JPanel panelBedienelemente = new JPanel();
	contentPane.add(panelBedienelemente, "cell 1 0,grow");
	panelBedienelemente.setLayout(new MigLayout("", "[125.00,grow]", "[grow][]"));
	
	JPanel panel = new JPanel();
//TitledBorder >> ist unter den properties des Panels zu finden und versieht das Panel mit einem Titel
	panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Handsteuerung", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	panelBedienelemente.add(panel, "cell 0 0,grow");
	panel.setLayout(new MigLayout("", "[87.00]", "[][][][][]"));
	
	JRadioButton rdbtnRot = new JRadioButton("Rot");
	rdbtnRot.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    panelAmpel.setRot();
		}
	});
	buttonGroup.add(rdbtnRot);
	panel.add(rdbtnRot, "cell 0 0");
	
	JRadioButton rdbtnRotgelb = new JRadioButton("RotGelb");
	rdbtnRotgelb.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    panelAmpel.setRotgelb();
		}
	});
	buttonGroup.add(rdbtnRotgelb);
	panel.add(rdbtnRotgelb, "cell 0 1");
	
	JRadioButton rdbtnGruen = new JRadioButton("Gr\u00FCn");
	rdbtnGruen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    panelAmpel.setGruen();
		}
	});
	buttonGroup.add(rdbtnGruen);
	panel.add(rdbtnGruen, "cell 0 2");
	
	JRadioButton rdbtnGelb = new JRadioButton("Gelb");
	rdbtnGelb.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    panelAmpel.setGelb();
		}
	});
	buttonGroup.add(rdbtnGelb);
	panel.add(rdbtnGelb, "cell 0 3");
	
	JRadioButton rdbtnAus = new JRadioButton("Aus");
	rdbtnAus.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    panelAmpel.setAus();
		}
	});
	rdbtnAus.setSelected(true);
	buttonGroup.add(rdbtnAus);
	panel.add(rdbtnAus, "cell 0 4");
	
	JCheckBox chckbxAutomatik = new JCheckBox("Automatik");
	panelBedienelemente.add(chckbxAutomatik, "cell 0 1,alignx center");
	chckbxAutomatik.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    // Boolean Wert ob ausgewählt oder nicht
			Boolean automatikSelected = chckbxAutomatik.isSelected();
	// Alle Radiobuttens deaktivieren wenn Automatik gewählt ist
			rdbtnRot.setEnabled(!automatikSelected);
			rdbtnRotgelb.setEnabled(!automatikSelected);
			rdbtnGelb.setEnabled(!automatikSelected);
			rdbtnGruen.setEnabled(!automatikSelected);
			rdbtnAus.setEnabled(!automatikSelected);
			if (chckbxAutomatik.isSelected()) {  //  if / else Schleife für die aktion wenn Automatik aktiviert
				//while (chckbxAutomatik.isSelected()) {  // while Schleife zum abarbeiten der einzelnen Ampelphasen
					try {                         // try / catch zum abfangen von Fehlern
						chckbxAutomatik.repaint();
						panelAmpel.setRot();
						Thread.sleep(rotPhase);
			//paintImmediately ist von der JComponent vererbt und zeichnet das Panel sofort neu
						panelAmpel.paintImmediately(0, 0, panelAmpel.getWidth(), panelAmpel.getHeight());
						panelAmpel.setRotgelb();
						Thread.sleep(rotgelbPhase);
						panelAmpel.paintImmediately(0, 0, panelAmpel.getWidth(), panelAmpel.getHeight());
						panelAmpel.setGruen();
						Thread.sleep(gruenPhase);
						panelAmpel.paintImmediately(0, 0, panelAmpel.getWidth(), panelAmpel.getHeight());
						panelAmpel.setGelb();
						Thread.sleep(gelbPhase);
						panelAmpel.paintImmediately(0, 0, panelAmpel.getWidth(), panelAmpel.getHeight());
					} catch (Exception ex) {
						ex.printStackTrace();
				   //}
				}
			} else {
				rdbtnAus.setSelected(true);
				panelAmpel.setPhase(null);
				panelAmpel.paintImmediately(0, 0, panelAmpel.getWidth(), panelAmpel.getHeight());
			}
			
			
		}
	});
    }
}
