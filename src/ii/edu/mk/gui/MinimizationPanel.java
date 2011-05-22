package ii.edu.mk.gui;

import ii.edu.mk.bisimulation.Graph;
import ii.edu.mk.io.AldebaranFile;
import ii.edu.mk.io.AldebaranUtils;
import ii.edu.mk.saturation.Saturator;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class MinimizationPanel extends JPanel{

	private final static Logger LOG = LogManager.getLogger(MinimizationPanel.class);
	
	private JFrame frameOwner = null;
	
	private File ltsFile = null;
	private JTextField ltsFileField = null;
	
	JRadioButton weakBisim;
	JRadioButton strongBisim;

	JRadioButton naiveMethod;
	JRadioButton fernandezMethod;
	
	Dimension vpDim = new Dimension(400, 400);
	JDialog dialog;
	ViewPanel viewPanel;
	
	public MinimizationPanel(JFrame owner) {
		this.frameOwner = owner;
		
		setLayout(new MigLayout("fill", "[10%]3px[90%]", "[30!]3px![30!]3px![30!]3px![30!]3px![30!]"));
		
		JLabel ltsLabel = new JLabel("LTS:");
		ltsFileField = new JTextField(256);
		ltsFileField.setFont(Parameters.DEFAULT_TEXT_FIELD_FONT.getValue());
		ltsFileField.setEditable(false);
		JButton browseLtsButton = new JButton("Browse");
		JButton clearLtsButton = new JButton("Clear");
		JButton viewLtsButton = new JButton("View");
		browseLtsButton.addActionListener(new BrowseAction(ltsFileField, this));
		clearLtsButton.addActionListener(new ClearAction());
		viewLtsButton.addActionListener(new ViewAction());
		
		add(ltsLabel);
		add(ltsFileField, "split 4, spanx");
		add(browseLtsButton);
		add(clearLtsButton);
		add(viewLtsButton, "wrap");
		
		JLabel bisimulationLabel = new JLabel("Bisimulation:");
		weakBisim = new JRadioButton("Weak");
		strongBisim = new JRadioButton("Strong");
		ButtonGroup bisimGroup = new ButtonGroup();
		bisimGroup.add(weakBisim);
		bisimGroup.add(strongBisim);

		add(bisimulationLabel);
		add(weakBisim, "split 2, al l");
		add(strongBisim, "al l, wrap");

		JLabel methodLabel = new JLabel("Method:");
		naiveMethod = new JRadioButton("Naive");
		fernandezMethod = new JRadioButton("Fernandez");
		ButtonGroup methodGroup = new ButtonGroup();
		methodGroup.add(naiveMethod);
		methodGroup.add(fernandezMethod);

		add(methodLabel);
		add(naiveMethod, "split 2, al l");
		add(fernandezMethod, "al l, wrap");

		JButton calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new CalculateAction());
		add(calculateButton, "wrap");
		
		viewPanel = new ViewPanel();
		dialog = new JDialog(this.frameOwner, true);
		dialog.setContentPane(viewPanel);
	}
	
	class BrowseAction implements ActionListener {
		private JTextField textField;
		private Component parent;
		private JFileChooser fileChooser;

		public BrowseAction(JTextField field, Component parent) {
			this.parent = parent;
			this.textField = field;
			fileChooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("LTS (Aldebaran)", "aut");
			fileChooser.setFileFilter(filter);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			fileChooser.showOpenDialog(parent);
			if (fileChooser.getSelectedFile() != null) {
				ltsFile = fileChooser.getSelectedFile();
				textField.setText(ltsFile.getAbsolutePath());
			}
		}
	}
	
	class ClearAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			clear();
		}
	}
	
	class ViewAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			viewFile(ltsFile);
		}
	}
	
	class CalculateAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
//			setCalculationStatusMessage("");// clear

			if (ltsFile == null) {
				if (ltsFile == null) LOG.debug("First LTS file is null");
				showMessageInPopUp("Must select a file with defined LTS in Aldebaran format.");
				return;
			}

			Boolean isStrongBisimChosen = isStrongBisimChosen();
			if (isStrongBisimChosen == null) {
				showMessageInPopUp("Must select a bisimilarity type.");
				return;
			}

			Boolean isNaiveMetodChosen = isNaiveMethodChosen();
			if (isNaiveMetodChosen == null) {
				showMessageInPopUp("Must select a calculation method.");
				return;
			}

			// try reading aldebaran files
			AldebaranFile alFile = null;
			try {
				alFile = AldebaranUtils.readFile(ltsFile);
			} catch (IOException ioe) {
				showMessageInPopUp("Selected files are not comp");
				return;
			}
			
			if (!isStrongBisimChosen) {
				alFile = Saturator.getInstance().saturate(alFile);
			}

			Graph graph = AldebaranUtils.generateGraphFromAldebaranFile(alFile);
			
			//TODO (CV): finish the implementation
		}
	}
	
	private void clear(){
		ltsFile = null;
		ltsFileField.setText("");
	}
	
	/**
	 * @return null - nothing is chosen, do not calculate anything, true - naive
	 *         method is choosen false- fernandez method is choosen
	 */
	private Boolean isNaiveMethodChosen() {
		if (!naiveMethod.isSelected() && !fernandezMethod.isSelected()) {
			return null;
		}
		if (naiveMethod.isSelected()) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	/**
	 * @return null - nothing is chosen, do not calculate anything, true -
	 *         strong method is choosen false- weak method is choosen
	 */
	private Boolean isStrongBisimChosen() {
		if (!strongBisim.isSelected() && !weakBisim.isSelected()) {
			return null;
		}
		if (strongBisim.isSelected()) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}
	
	private void viewFile(File file) {
		if (file != null) {
			try {
				viewPanel.showFile(file);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				dialog.setLocation((dim.width / 2) - (vpDim.width / 2), (dim.height / 2) - (vpDim.height / 2));
				dialog.pack();
				dialog.setVisible(true);
			} catch (IOException e) {
				showMessageInPopUp("Can not load the file.");
			}
		}
	}
	
	private void showMessageInPopUp(final String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
	private class ViewPanel extends JPanel {
		private JTextArea textArea;
		private JScrollPane scroll;

		public ViewPanel() {
			this.setMinimumSize(vpDim);
			this.setPreferredSize(vpDim);
			this.setMaximumSize(vpDim);
			this.setLayout(new MigLayout("fill", "[100%]", "[100%]"));
			textArea = new JTextArea();
			textArea.setFont(Parameters.DEFAULT_TEXT_FIELD_FONT.getValue());
			textArea.setEditable(false);
			scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			this.add(scroll, "grow");
		}

		public void showFile(File file) throws IOException {
			textArea.setText(AldebaranUtils.toString(AldebaranUtils.readFile(file), true));
		}
	}

}
