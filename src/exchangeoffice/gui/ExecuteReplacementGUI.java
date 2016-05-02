package exchangeoffice.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class ExecuteReplacementGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblPurchasableRate;
	private JLabel lblSalesRate;
	private JTextField textFieldSales;
	private JTextField textFieldPurchasable;
	private JLabel lblAmount;
	private JTextField textFieldAmount;
	private JLabel lblTransactionType;
	private JRadioButton rdbtnPurchase;
	private JRadioButton rdbtnSale;
	private JSlider sliderAmount;
	private JComboBox<String> comboBox;
	private JButton btnExecuteExchange;
	private JButton btnCancel;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the frame.
	 */
	public ExecuteReplacementGUI() {
		setResizable(false);
		setTitle("Execute replacement");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblPurchasableRate());
		contentPane.add(getLblSalesRate());
		contentPane.add(getTextFieldSales());
		contentPane.add(getTextFieldPurchasable());
		contentPane.add(getLblAmount());
		contentPane.add(getTextFieldAmount());
		contentPane.add(getLblTransactionType());
		contentPane.add(getRdbtnPurchase());
		contentPane.add(getRdbtnSale());
		contentPane.add(getSliderAmount());
		contentPane.add(getComboBox());
		contentPane.add(getBtnExecuteExchange());
		contentPane.add(getBtnCancel());
	}

	private JLabel getLblPurchasableRate() {
		if (lblPurchasableRate == null) {
			lblPurchasableRate = new JLabel("Purchasable rate");
			lblPurchasableRate.setBounds(10, 11, 150, 20);
		}
		return lblPurchasableRate;
	}

	private JLabel getLblSalesRate() {
		if (lblSalesRate == null) {
			lblSalesRate = new JLabel("Sales rate");
			lblSalesRate.setBounds(334, 11, 150, 20);
		}
		return lblSalesRate;
	}

	private JTextField getTextFieldSales() {
		if (textFieldSales == null) {
			textFieldSales = new JTextField();
			textFieldSales.setEditable(false);
			textFieldSales.setBounds(334, 42, 150, 20);
			textFieldSales.setColumns(10);
		}
		return textFieldSales;
	}

	private JTextField getTextFieldPurchasable() {
		if (textFieldPurchasable == null) {
			textFieldPurchasable = new JTextField();
			textFieldPurchasable.setEditable(false);
			textFieldPurchasable.setBounds(10, 42, 150, 20);
			textFieldPurchasable.setColumns(10);
		}
		return textFieldPurchasable;
	}

	private JLabel getLblAmount() {
		if (lblAmount == null) {
			lblAmount = new JLabel("Amount");
			lblAmount.setBounds(10, 83, 143, 20);
		}
		return lblAmount;
	}

	private JTextField getTextFieldAmount() {
		if (textFieldAmount == null) {
			textFieldAmount = new JTextField();
			textFieldAmount.setBounds(10, 114, 150, 20);
			textFieldAmount.setColumns(10);

		}
		return textFieldAmount;
	}

	private JLabel getLblTransactionType() {
		if (lblTransactionType == null) {
			lblTransactionType = new JLabel("Transaction type");
			lblTransactionType.setBounds(268, 83, 150, 20);
		}
		return lblTransactionType;
	}

	private JRadioButton getRdbtnPurchase() {
		if (rdbtnPurchase == null) {
			rdbtnPurchase = new JRadioButton("Purchase");
			rdbtnPurchase.setActionCommand("Purchase");
			buttonGroup.add(rdbtnPurchase);
			rdbtnPurchase.setBounds(268, 114, 150, 20);
		}
		return rdbtnPurchase;
	}

	private JRadioButton getRdbtnSale() {
		if (rdbtnSale == null) {
			rdbtnSale = new JRadioButton("Sale");
			rdbtnSale.setActionCommand("Sale");
			buttonGroup.add(rdbtnSale);
			rdbtnSale.setBounds(268, 137, 150, 20);
		}
		return rdbtnSale;
	}

	private JSlider getSliderAmount() {
		if (sliderAmount == null) {
			sliderAmount = new JSlider();
			sliderAmount.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					textFieldAmount.setText(Integer.toString(sliderAmount.getValue()));
				}
			});
			sliderAmount.setMinorTickSpacing(5);
			sliderAmount.setPaintLabels(true);
			sliderAmount.setMajorTickSpacing(10);
			sliderAmount.setPaintTicks(true);
			sliderAmount.setBounds(10, 164, 474, 50);
			textFieldAmount.setText(Integer.toString(sliderAmount.getValue()));

		}
		return sliderAmount;
	}

	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
			comboBox.setBounds(170, 42, 150, 20);
			comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "EUR", "USD", "CHF" }));
		}
		return comboBox;
	}

	private JButton getBtnExecuteExchange() {
		if (btnExecuteExchange == null) {
			btnExecuteExchange = new JButton("Execute exchange");
			btnExecuteExchange.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIController.showRateInStatusBar(buttonGroup.getSelection().getActionCommand() + " "
							+ textFieldAmount.getText() + " " + (String) comboBox.getSelectedItem() + ".");
				}
			});
			btnExecuteExchange.setBounds(10, 230, 150, 30);
		}
		return btnExecuteExchange;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnCancel.setBounds(334, 230, 150, 30);
		}
		return btnCancel;
	}

}
