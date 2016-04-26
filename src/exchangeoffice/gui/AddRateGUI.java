package exchangeoffice.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import exchangeoffice.Rate;

@SuppressWarnings("serial")
public class AddRateGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblPassword;
	private JLabel lblName;
	private JTextField textFieldPassword;
	private JTextField textFieldName;
	private JLabel lblSales;
	private JLabel lblPurchasable;
	private JTextField textFieldSales;
	private JTextField textFieldPurchasable;
	private JLabel lblMiddle;
	private JLabel lblAbbreviatedName;
	private JTextField textFieldMiddle;
	private JTextField textFieldAbbreviatedName;
	private JButton btnAdd;
	private JButton btnCancel;

	/**
	 * Create the frame.
	 */
	public AddRateGUI() {
		setResizable(false);
		setTitle("Add rate");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 7));
		contentPane.add(getLblPassword());
		contentPane.add(getLblName());
		contentPane.add(getTextField_1());
		contentPane.add(getTextField_2());
		contentPane.add(getLblSales());
		contentPane.add(getLblPurchasable());
		contentPane.add(getTextField_3());
		contentPane.add(getTextField_4());
		contentPane.add(getLblMiddle());
		contentPane.add(getLblAbbreviatedName());
		contentPane.add(getTextField_5());
		contentPane.add(getTextField_6());
		contentPane.add(getBtnAdd());
		contentPane.add(getBtnCancel());
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
		}
		return lblPassword;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name");
		}
		return lblName;
	}

	private JTextField getTextField_1() {
		if (textFieldPassword == null) {
			textFieldPassword = new JTextField();
			textFieldPassword.setColumns(10);
		}
		return textFieldPassword;
	}

	private JTextField getTextField_2() {
		if (textFieldName == null) {
			textFieldName = new JTextField();
			textFieldName.setColumns(10);
		}
		return textFieldName;
	}

	private JLabel getLblSales() {
		if (lblSales == null) {
			lblSales = new JLabel("Sales");
		}
		return lblSales;
	}

	private JLabel getLblPurchasable() {
		if (lblPurchasable == null) {
			lblPurchasable = new JLabel("Purchasable");
		}
		return lblPurchasable;
	}

	private JTextField getTextField_3() {
		if (textFieldSales == null) {
			textFieldSales = new JTextField();
			textFieldSales.setColumns(10);
		}
		return textFieldSales;
	}

	private JTextField getTextField_4() {
		if (textFieldPurchasable == null) {
			textFieldPurchasable = new JTextField();
			textFieldPurchasable.setColumns(10);
		}
		return textFieldPurchasable;
	}

	private JLabel getLblMiddle() {
		if (lblMiddle == null) {
			lblMiddle = new JLabel("Middle");
		}
		return lblMiddle;
	}

	private JLabel getLblAbbreviatedName() {
		if (lblAbbreviatedName == null) {
			lblAbbreviatedName = new JLabel("Abbreviated name");
		}
		return lblAbbreviatedName;
	}

	private JTextField getTextField_5() {
		if (textFieldMiddle == null) {
			textFieldMiddle = new JTextField();
			textFieldMiddle.setColumns(10);
		}
		return textFieldMiddle;
	}

	private JTextField getTextField_6() {
		if (textFieldAbbreviatedName == null) {
			textFieldAbbreviatedName = new JTextField();
			textFieldAbbreviatedName.setColumns(10);
		}
		return textFieldAbbreviatedName;
	}

	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Rate rate = new Rate();
					rate.setPassword(textFieldPassword.getText());
					rate.setName(textFieldName.getText());
					rate.setSales(textFieldSales.getText());
					rate.setPurchasable(textFieldPurchasable.getText());
					rate.setMiddle(textFieldMiddle.getText());
					rate.setAbbreviatedName(textFieldAbbreviatedName.getText());

					GUIController.rates.add(rate);

					GUIController.showRate();
				}
			});
		}
		return btnAdd;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return btnCancel;
	}
}
