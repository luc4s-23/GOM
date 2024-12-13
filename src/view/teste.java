package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class teste extends JFrame {
	private JTable table;

	public teste() {

		String[] columnNames = { "ID", "Nome", "Idade" };
		Object[][] data = { { 1, "João", 25 }, { 2, "Maria", 30 } };

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		setVisible(true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 64, 592, 359);
		panel.add(scrollPane);
		
				table = new JTable();
				scrollPane.setViewportView(table);
				table.setModel(new DefaultTableModel(new Object[][] {},
						new String[] { "Fabricante", "Modelo", "Ano", "Motor", "Placa" }));
				table.setModel(model);
	}

	public static void main(String[] args) {
		new teste();
	}
}
