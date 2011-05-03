package ii.edu.mk.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.miginfocom.swing.MigLayout;

/**
 * 
 * @author Vladimir Carevski
 */
@SuppressWarnings("serial")
public class BisimulationPanel extends JPanel{

	private File lts1File;
	private File lts2File;
	private JLabel calculationStatusLabel;
	
	JRadioButton weakBisim;
	JRadioButton strongBisim;
	
	JRadioButton naiveMethod;
	JRadioButton fernandezMethod;
	
	public BisimulationPanel() {
		setLayout(new MigLayout("fill", 
				"[10%]3px[90%]",
				"[30!]3px![30!]3px![30!]3px![30!]3px![30!]"));
		
		JLabel ltsLabel1 = new JLabel("LTS 1:");
		JTextField ltsFileField1 = new JTextField(256);
		ltsFileField1.setEditable(false);
		JButton browseLts1Button = new JButton("Browse");
		JButton clearLts1Button = new JButton("Clear");
		JButton viewLts1Button = new JButton("View");
		browseLts1Button.addActionListener(new ChooseFileAction(lts1File, ltsFileField1,  this));
		
		JLabel ltsLabel2 = new JLabel("LTS 2:");
		JTextField ltsFileField2 = new JTextField(256);
		ltsFileField2.setEditable(false);
		JButton browseLts2Button = new JButton("Browse");
		JButton clearLts2Button = new JButton("Clear");
		JButton viewLts2Button = new JButton("View");
		browseLts2Button.addActionListener(new ChooseFileAction(lts2File, ltsFileField2, this));
		
		add(ltsLabel1);
		add(ltsFileField1, "split 4, spanx");
		add(browseLts1Button);
		add(clearLts1Button);
		add(viewLts1Button, "wrap");
		
		add(ltsLabel2);
		add(ltsFileField2, "split 4, spanx");
		add(browseLts2Button);
		add(clearLts2Button);
		add(viewLts2Button, "wrap");
		
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
		JRadioButton naiveMethod = new JRadioButton("Naive");
		JRadioButton fernandezMethod = new JRadioButton("Fernandez");
		ButtonGroup methodGroup = new ButtonGroup();
		methodGroup.add(naiveMethod);
		methodGroup.add(fernandezMethod);
		
		add(methodLabel);
		add(naiveMethod, "split 2, al l");
		add(fernandezMethod, "al l, wrap");
		
		JButton calculate = new JButton("Calculate");
		calculate.addActionListener(new CalculateAction());
		calculationStatusLabel = new JLabel("results");
		
		add(calculate);
		add(calculationStatusLabel);
		
	}
	
	class ChooseFileAction implements ActionListener{
		private File file;
		private JTextField textField;
		private Component parent;
		private JFileChooser fileChooser;
		
		public ChooseFileAction(File file, JTextField field, Component parent) {
			this.file = file; this.parent = parent; this.textField = field;
			fileChooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("LTS (Aldebaran)", "aut");
			fileChooser.setFileFilter(filter);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			fileChooser.showOpenDialog(parent);
			if(fileChooser.getSelectedFile()!=null){
				file = fileChooser.getSelectedFile();
				textField.setText(file.getAbsolutePath());
			}
		}
	}
	
	class ClearFileAction implements ActionListener{
		@SuppressWarnings("unused")
		private File file;
		private JTextField textField;
		public ClearFileAction(File file, JTextField textField) {
			this.file = file; this.textField = textField;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			this.file = null; textField.setText("");
		}
	}
	
	class CalculateAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	/**
	 * @return null - nothing is chosen, do not calculate anything,
	 * 		   true - strong bisimulation is choosen
	 * 		   false- weak bisimulation is choosen
	 */
	private Boolean isStrongBisimChosen(){
		if(!weakBisim.isSelected() && !strongBisim.isSelected()){
			return null;
		}
		if(strongBisim.isSelected()){
			return Boolean.TRUE;
		}else{
			return Boolean.FALSE;
		}
	}
	
	/**
	 * @return null - nothing is chosen, do not calculate anything,
	 * 		   true - naive method is choosen
	 * 		   false- fernandez method is choosen
	 */
	private Boolean isNaiveMethodChosen(){
		if(!naiveMethod.isSelected() && !fernandezMethod.isSelected()){
			return null;
		}
		if(naiveMethod.isSelected()){
			return Boolean.TRUE;
		}else{
			return Boolean.FALSE;
		}
	}
	
	private void setCalculationStatusMessage(String message){
		calculationStatusLabel.setText(message);
	}
	
}
