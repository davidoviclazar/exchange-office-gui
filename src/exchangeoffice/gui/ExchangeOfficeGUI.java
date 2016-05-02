package exchangeoffice.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

import exchangeoffice.gui.models.ExchangeOfficeTableModel;

@SuppressWarnings("serial")
public class ExchangeOfficeGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panelEast;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenuItem mntmAbout;
	private JScrollPane scrollPaneCenter;
	private static JTable table;
	private JButton btnAddRate;
	private JButton btnDeleteRate;
	private JButton btnCommitReplacement;
	private static JTextArea textAreaSouth;
	private JPopupMenu popupMenu;
	private JMenuItem mntmAddRate;
	private JMenuItem mntmDeleteRate;
	private JMenuItem mntmCommitReplacement;
	private JScrollPane scrollPaneSouth;

	/**
	 * Create the frame.
	 */
	public ExchangeOfficeGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./resources/icons/euro.png"));
		setTitle("Exchange office");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelEast(), BorderLayout.EAST);
		contentPane.add(getScrollPaneCenter(), BorderLayout.CENTER);
		contentPane.add(getScrollPaneSouth(), BorderLayout.SOUTH);
		setSize(1000, 500);
	}

	private JPanel getPanelEast() {
		if (panelEast == null) {
			panelEast = new JPanel();
			panelEast.setPreferredSize(new Dimension(225, 10));
			panelEast.add(getBtnAddRate());
			panelEast.add(getBtnDeleteRate());
			panelEast.add(getBtnCommitReplacement());
		}
		return panelEast;
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}

	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmSave());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}

	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}

	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					textAreaSouth.setText(GUIController.showOpenDialog());

				}
			});
			mntmOpen.setIcon(new ImageIcon(
					ExchangeOfficeGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		}
		return mntmOpen;
	}

	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textAreaSouth.setText(GUIController.showSaveDialog());
				}
			});
			mntmSave.setIcon(new ImageIcon(
					ExchangeOfficeGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
			mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		}
		return mntmSave;
	}

	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIController.closeAplication();
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		}
		return mntmExit;
	}

	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIController.showAuthors();
				}
			});
		}
		return mntmAbout;
	}

	private JScrollPane getScrollPaneCenter() {
		if (scrollPaneCenter == null) {
			scrollPaneCenter = new JScrollPane();
			addPopup(scrollPaneCenter, getPopupMenu());
			scrollPaneCenter.setViewportView(getTable());
		}
		return scrollPaneCenter;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			ExchangeOfficeTableModel model = new ExchangeOfficeTableModel(null);
			table.setModel(model);
		}
		return table;
	}

	private JButton getBtnAddRate() {
		if (btnAddRate == null) {
			btnAddRate = new JButton("Add rate");
			btnAddRate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIController.addRateGUI();
				}
			});
			btnAddRate.setPreferredSize(new Dimension(200, 25));
		}
		return btnAddRate;
	}

	private JButton getBtnDeleteRate() {
		if (btnDeleteRate == null) {
			btnDeleteRate = new JButton("Delete rate");
			btnDeleteRate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIController.deleteRow(table.getSelectedRow());
				}
			});
			btnDeleteRate.setPreferredSize(new Dimension(200, 25));
		}
		return btnDeleteRate;
	}

	private JButton getBtnCommitReplacement() {
		if (btnCommitReplacement == null) {
			btnCommitReplacement = new JButton("Commit replacement");
			btnCommitReplacement.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIController.executeReplacementGUI();
				}
			});
			btnCommitReplacement.setPreferredSize(new Dimension(200, 25));
		}
		return btnCommitReplacement;
	}

	private JTextArea getTextArea() {
		if (textAreaSouth == null) {
			textAreaSouth = new JTextArea();
			textAreaSouth.setBorder(new TitledBorder(null, "STATUS", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		}
		return textAreaSouth;
	}

	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMntmAddRate());
			popupMenu.add(getMntmDeleteRate());
			popupMenu.add(getMntmCommitReplacement());
		}
		return popupMenu;
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	private JMenuItem getMntmAddRate() {
		if (mntmAddRate == null) {
			mntmAddRate = new JMenuItem("Add rate");
			mntmAddRate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIController.addRateGUI();
				}
			});
		}
		return mntmAddRate;
	}

	private JMenuItem getMntmDeleteRate() {
		if (mntmDeleteRate == null) {
			mntmDeleteRate = new JMenuItem("Delete rate");
		}
		return mntmDeleteRate;
	}

	private JMenuItem getMntmCommitReplacement() {
		if (mntmCommitReplacement == null) {
			mntmCommitReplacement = new JMenuItem("Commit replacement");
			mntmCommitReplacement.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIController.executeReplacementGUI();
				}
			});
		}
		return mntmCommitReplacement;
	}

	public void setStatusText(String text) {
		textAreaSouth.setText(textAreaSouth.getText() + "\n" + text);
	}

	public void setTableModel(TableModel model) {
		table.setModel(model);
	}

	private JScrollPane getScrollPaneSouth() {
		if (scrollPaneSouth == null) {
			scrollPaneSouth = new JScrollPane();
			scrollPaneSouth.setViewportView(getTextArea());
		}
		return scrollPaneSouth;
	}
}