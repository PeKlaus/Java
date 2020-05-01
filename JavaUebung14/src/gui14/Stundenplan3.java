package gui14;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Stundenplan3 extends JFrame {

	private JPanel contentPane;
	private JTable tableStundenplan;
	private String dateiname = "." + File.separator + " stundenplanV2.dat";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stundenplan frame = new Stundenplan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public Stundenplan3() throws FileNotFoundException, IOException {
	// Speichern der Tabelle beim Schlieﬂen des Programms
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try (BufferedWriter out = new BufferedWriter(new FileWriter(dateiname))) {
				// Verschachtelte For Schleife zum einlesen der Eintr‰ge
				    for (int i = 0; i < tableStundenplan.getModel() // da das TabelModel nur lokal erstellt wurde wird es mit .getModel aufgerufen
					    .getRowCount(); i++) {
					for (int j = 1; j < tableStundenplan.getModel()
						.getColumnCount(); j++) {
					    if (tableStundenplan.getModel().getValueAt(i, j) != null) {
						out.write(tableStundenplan.getModel()
							.getValueAt(i, j).toString()); // Wandelt das Objekt in einen String um
					    } else {
						out.write("");
					    }

					    out.newLine();
					}
				    }
				} catch (Exception ex) {
				    ex.printStackTrace();
				}
			    }
			});
		setTitle("Stundenplan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 0,grow");
	// In die JScrollpane eingef¸gte JTable
		tableStundenplan = new JTable();
		tableStundenplan.setModel(new DefaultTableModel(
			new String[][] { },
			new String[] {
				"Stunde", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag"
			}
		));
		scrollPane.setViewportView(tableStundenplan);
		
	// Datei einlesen falls vorhanden
		File datei = new File(dateiname);
		if (!datei.exists()) { // pr¸fen ob eine Datei existiert
			try {
				datei.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else {
			try (BufferedReader in = new BufferedReader(new FileReader(dateiname))) {
				
			// mit for schleife werden die Eintr‰ge Zeilenweise und Spaltenweise eingelesen
				String eintrag;
				for (int i = 0;
						i < tableStundenplan.getModel().getRowCount(); i++) {
					for (int j = 1; j < tableStundenplan.getModel().getColumnCount(); j++) {
						eintrag = in.readLine();
						tableStundenplan.getModel().setValueAt(eintrag, i, j);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}