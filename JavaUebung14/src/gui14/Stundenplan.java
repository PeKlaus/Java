package gui14;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Stundenplan extends JFrame {

	private JPanel contentPane;
	private JTable tableStundenplan;
    

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
	 */
	public Stundenplan() {
		setTitle("Stundenplan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 0,grow");
	// In die JScrollpane eingefügte JTable
		tableStundenplan = new JTable();
		tableStundenplan.setModel(new DefaultTableModel(
	// Unter den Properties der Tabelle > Models generierte Tabelle
			new Object[][] {
				{"1", null, null, null, null, null},
				{"2", null, null, null, null, null},
				{"3", null, null, null, null, null},
				{"4", null, null, null, null, null},
				{"5", null, null, null, null, null},
				{"6", null, null, null, null, null},
				{"7", null, null, null, null, null},
				{"8", null, null, null, null, null},
				{"9", null, null, null, null, null},
				{"10", null, null, null, null, null},
			},
			new String[] { // Titel der einzelnen Spalten 
				"Stunde", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag"
			}
		));
		scrollPane.setViewportView(tableStundenplan);
		
	}

}
