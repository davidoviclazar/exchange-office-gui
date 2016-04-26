package exchangeoffice.gui.models;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ExchangeOfficeTableModel extends AbstractTableModel {

	private final String[] columns = new String[] { "Password", "Abbreviated name", "Sales", "Middle", "Purchasable",
			"Name" };

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		return null;
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
