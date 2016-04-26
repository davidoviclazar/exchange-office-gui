package exchangeoffice.gui.models;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import exchangeoffice.Rate;

@SuppressWarnings("serial")
public class ExchangeOfficeTableModel extends AbstractTableModel {

	private final String[] columns = new String[] { "Password", "Abbreviated name", "Sales", "Middle", "Purchasable",
			"Name" };
	private LinkedList<Rate> rates;

	public ExchangeOfficeTableModel(LinkedList<Rate> rates) {
		if (rates == null) {
			this.rates = new LinkedList<Rate>();
		} else {
			this.rates = rates;
		}
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return rates.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Rate rate = rates.get(arg0);
		switch (arg1) {
		case 0:
			return rate.getPassword();

		case 1:
			return rate.getAbbreviatedName();

		case 2:
			return rate.getSales();

		case 3:
			return rate.getMiddle();
		case 4:
			return rate.getPurchasable();
		case 5:
			return rate.getName();
		default:
			return "";
		}
	}

	@Override
	public String getColumnName(int arg0) {
		return columns[arg0];

	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

}
