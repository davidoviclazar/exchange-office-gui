package exchangeoffice.gui;

import java.awt.EventQueue;
import java.io.File;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import exchangeoffice.Rate;
import exchangeoffice.gui.models.ExchangeOfficeTableModel;

public class GUIController {
	public static LinkedList<Rate> rates = new LinkedList<Rate>();
	private static ExchangeOfficeGUI frame;
	private static ExchangeOfficeTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ExchangeOfficeGUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static String showOpenDialog() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(frame.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				return "Loaded file: " + file.getAbsolutePath();
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(frame.getContentPane(), e1.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}

	public static String showSaveDialog() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(frame.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				return "File saved: " + file.getAbsolutePath();
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(frame.getContentPane(), e1.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}

	public static void closeAplication() {
		int option = JOptionPane.showConfirmDialog(frame.getContentPane(), "Do you want to close the program?",
				"Close aplication", JOptionPane.YES_NO_OPTION);

		if (option == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}

	public static void showAuthors() {
		String authors = "Lazar Davidovic";
		JOptionPane.showMessageDialog(frame, authors, "Author", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void showRate() {
		String text = "";
		for (Rate rate : rates) {
			text = "Password: " + rate.getPassword() + "Name: " + rate.getName() + "Sales: " + rate.getSales()
					+ "Purchasable: " + rate.getPurchasable() + "Middle: " + rate.getMiddle() + "Abbreviated name: "
					+ rate.getAbbreviatedName();
		}
		showRateInStatusBar(text);
		refreshTable(rates);

	}

	public static void showRateInStatusBar(String text) {

		frame.setStatusText(text);

	}

	public static void refreshTable(LinkedList<Rate> rates) {
		model = new ExchangeOfficeTableModel(rates);
		model.fireTableDataChanged();
		frame.setTableModel(model);

	}

	public static void addRateGUI() {
		/**
		 * Launch the form.
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRateGUI addRate = new AddRateGUI();
					addRate.setVisible(true);
					addRate.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void deleteRow(int selectedRow) {
		if (selectedRow == -1) {
			showWrongChoiceDialog();
		} else {
			int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the selected rate?",
					"Delete rate", JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				rates.remove(selectedRow);
				refreshTable(rates);
				showSuccessfullyDeleteRateDialog();
				showRateInStatusBar("Deleted row with index: " + selectedRow + "!");

			} else {
				showUnsuccessfulDeleteRateDialog();
			}
		}

	}

	private static void showUnsuccessfulDeleteRateDialog() {
		JOptionPane.showMessageDialog(frame.getContentPane(), "Rate not deleted!", "Failure",
				JOptionPane.ERROR_MESSAGE);
	}

	private static void showSuccessfullyDeleteRateDialog() {
		JOptionPane.showMessageDialog(frame.getContentPane(), "Rate successfully deleted!", "Success",
				JOptionPane.INFORMATION_MESSAGE);
	}

	private static void showWrongChoiceDialog() {
		JOptionPane.showMessageDialog(frame.getContentPane(), "Choose rate for deletion!", "Error",
				JOptionPane.ERROR_MESSAGE);
	}
}
