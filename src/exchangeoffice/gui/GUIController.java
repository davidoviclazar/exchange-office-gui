package exchangeoffice.gui;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class GUIController {
	private static ExchangeOfficeGUI frame;

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

}
