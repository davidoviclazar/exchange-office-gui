package exchangeoffice.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
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
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnAddRate;
	private JButton btnDeleteRate;
	private JButton btnCommitReplacement;
	private JTextArea textAreaSouth;
	private JPopupMenu popupMenu;
	private JMenuItem mntmAddRate;
	private JMenuItem mntmDeleteRate;
	private JMenuItem mntmCommitReplacement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExchangeOfficeGUI frame = new ExchangeOfficeGUI();
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
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		contentPane.add(getTextArea_1(), BorderLayout.SOUTH);
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
			mntmOpen.setIcon(new ImageIcon(
					ExchangeOfficeGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		}
		return mntmOpen;
	}

	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.setIcon(new ImageIcon(
					ExchangeOfficeGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
			mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		}
		return mntmSave;
	}

	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		}
		return mntmExit;
	}

	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
		}
		return mntmAbout;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			addPopup(scrollPane, getPopupMenu());
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			ExchangeOfficeTableModel model = new ExchangeOfficeTableModel();
			table.setModel(model);
		}
		return table;
	}

	private JButton getBtnAddRate() {
		if (btnAddRate == null) {
			btnAddRate = new JButton("Add rate");
			btnAddRate.setPreferredSize(new Dimension(200, 25));
		}
		return btnAddRate;
	}

	private JButton getBtnDeleteRate() {
		if (btnDeleteRate == null) {
			btnDeleteRate = new JButton("Delete rate");
			btnDeleteRate.setPreferredSize(new Dimension(200, 25));
		}
		return btnDeleteRate;
	}

	private JButton getBtnCommitReplacement() {
		if (btnCommitReplacement == null) {
			btnCommitReplacement = new JButton("Commit replacement");
			btnCommitReplacement.setPreferredSize(new Dimension(200, 25));
		}
		return btnCommitReplacement;
	}

	private JTextArea getTextArea_1() {
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
		}
		return mntmCommitReplacement;
	}
}
