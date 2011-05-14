package ii.edu.mk.gui;

import ii.edu.mk.bisimulation.Graph;
import ii.edu.mk.bisimulation.ListPairProcess;
import ii.edu.mk.bisimulation.Partition;
import ii.edu.mk.io.AldebaranFile;
import ii.edu.mk.io.AldebaranUtils;

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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jdesktop.swingx.JXFrame;

/**
 * 
 * @author Vladimir Carevski
 */
@SuppressWarnings("serial")
public class BisimulationPanel extends JPanel{

	private final static Logger LOG = LogManager.getLogger(BisimulationPanel.class);
	
	private final JXFrame frameOwner;
	
	private File lts1File;
	private File lts2File;
	private JLabel calculationStatusLabel;
	
	JRadioButton weakBisim;
	JRadioButton strongBisim;
	
	JRadioButton naiveMethod;
	JRadioButton fernandezMethod;
	
	Dimension vpDim = new Dimension(400, 400);
	JDialog dialog;
	ViewPanel viewPanel;
	
	public BisimulationPanel(final JXFrame frameOwner) {
		this.frameOwner = frameOwner;
		
		setLayout(new MigLayout("fill", 
				"[10%]3px[90%]",
				"[30!]3px![30!]3px![30!]3px![30!]3px![30!]"));
		
		JLabel ltsLabel1 = new JLabel("LTS 1:");
		JTextField ltsFileField1 = new JTextField(256);
		ltsFileField1.setEditable(false);
		JButton browseLts1Button = new JButton("Browse");
		JButton clearLts1Button = new JButton("Clear");
		JButton viewLts1Button = new JButton("View");
		browseLts1Button.addActionListener(new ChooseFile1Action(ltsFileField1,  this));
		clearLts1Button.addActionListener(new ClearFile1Action(ltsFileField1));
		viewLts1Button.addActionListener(new ViewFile1Action());
		
		JLabel ltsLabel2 = new JLabel("LTS 2:");
		JTextField ltsFileField2 = new JTextField(256);
		ltsFileField2.setEditable(false);
		JButton browseLts2Button = new JButton("Browse");
		JButton clearLts2Button = new JButton("Clear");
		JButton viewLts2Button = new JButton("View");
		browseLts2Button.addActionListener(new ChooseFile2Action(ltsFileField2, this));
		clearLts2Button.addActionListener(new ClearFile2Action(ltsFileField2));
		viewLts2Button.addActionListener(new ViewFile2Action());
		
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
		
		JLabel methodLabel = new JLabel("Method:");
		naiveMethod = new JRadioButton("Naive");
		fernandezMethod = new JRadioButton("Fernandez");
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
		
		viewPanel = new ViewPanel();
		dialog = new JDialog(this.frameOwner, true);
		dialog.setContentPane(viewPanel);
	}
	
	class ChooseFile1Action implements ActionListener{
		private JTextField textField;
		private Component parent;
		private JFileChooser fileChooser;
		
		public ChooseFile1Action(JTextField field, Component parent) {
			this.parent = parent; this.textField = field;
			fileChooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("LTS (Aldebaran)", "aut");
			fileChooser.setFileFilter(filter);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			fileChooser.showOpenDialog(parent);
			if(fileChooser.getSelectedFile()!=null){
				lts1File = fileChooser.getSelectedFile();
				textField.setText(lts1File.getAbsolutePath());
			}
		}
	}
	
	class ChooseFile2Action implements ActionListener{
		private JTextField textField;
		private Component parent;
		private JFileChooser fileChooser;
		
		public ChooseFile2Action(JTextField field, Component parent) {
			this.parent = parent; this.textField = field;
			fileChooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("LTS (Aldebaran)", "aut");
			fileChooser.setFileFilter(filter);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			fileChooser.showOpenDialog(parent);
			if(fileChooser.getSelectedFile()!=null){
				lts2File = fileChooser.getSelectedFile();
				textField.setText(lts2File.getAbsolutePath());
			}
		}
	}
	
	class ClearFile1Action implements ActionListener{
		private JTextField textField;
		public ClearFile1Action(JTextField textField) {
			this.textField = textField;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			lts1File = null;
			textField.setText("");
		}
	}
	
	class ClearFile2Action implements ActionListener {
		private JTextField textField;
		public ClearFile2Action(JTextField textField) {
			this.textField = textField;}
		@Override
		public void actionPerformed(ActionEvent e) {
			lts2File = null;textField.setText("");
		}
	}
	
	class ViewFile1Action implements ActionListener {
		@Override public void actionPerformed(ActionEvent arg0) { viewFile(lts1File); }
	}
	
	class ViewFile2Action implements ActionListener {
		@Override public void actionPerformed(ActionEvent arg0) { viewFile(lts2File); }
	}
	
	private void viewFile(File file){
		if(file != null){
			try{
				viewPanel.showFile(file);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				dialog.setLocation((dim.width/2)- (vpDim.width/2), (dim.height / 2)-(vpDim.height/2));
				dialog.pack();
				dialog.setVisible(true);
			}catch (IOException e) {
				showMessageInPopUp("Can not load the file.");
			}
		}
	}
	
	class CalculateAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			setCalculationStatusMessage("");//clear
			
			//check to see if all needed data are submitted, before doing any processing
			if(lts1File == null || lts2File == null){
				if(lts1File == null) LOG.debug("First LTS file is null");
				if(lts2File == null) LOG.debug("Second LTS file is null");
				showMessageInPopUp("Must select two files with defined LTS in Aldebaran format.");
				return;
			}
			Boolean isNaiveMetodChosen = isNaiveMethodChosen();
			if(isNaiveMetodChosen == null){
				showMessageInPopUp("Must select a bisimilarity calculation method");
				return;
			}
			
			//try reading aldebaran files
			AldebaranFile file1 = null;
			AldebaranFile file2 = null;
			try{
				file1 = AldebaranUtils.readFile(lts1File);
				file2 = AldebaranUtils.readFile(lts2File);
			} catch (IOException ioe) {
				showMessageInPopUp("Selected files are not comp");
				return;
			}
			
			
			Graph graph1 = AldebaranUtils.generateGraphFromAldebaranFile(file1);
			Graph graph2 = AldebaranUtils.generateGraphFromAldebaranFile(file2);
			
			boolean bisimilar = false;
			long time = System.currentTimeMillis();
			if(isNaiveMetodChosen){
				ListPairProcess lpp1 = graph1.findStrongBisimulationNaive();
				ListPairProcess lpp2 = graph2.findStrongBisimulationNaive();
				
				graph1.minimizationGraph(lpp1);
				graph2.minimizationGraph(lpp2);
				
				bisimilar = graph1.equalGraph(graph1.getInitialNode(), graph1, graph2.getInitialNode());
			}else{
				Partition par1 = graph1.findStrongBisimulationFernandez();
				Partition par2 = graph2.findStrongBisimulationFernandez();
				
				graph1.minimizationGraph(par1);
				graph2.minimizationGraph(par2);
				
				bisimilar = graph1.equalGraph(graph1.getInitialNode(), graph1, graph2.getInitialNode());
			}
			time = System.currentTimeMillis() - time;
			
			StringBuilder builder = new StringBuilder();
			builder.append("Bisimilar: ");
			builder.append(bisimilar ? "true" : "false");
			builder.append(" -- ");
			builder.append("Lasted: ");
			builder.append(String.format("%d sec.", (time / 1000) ));
			
			setCalculationStatusMessage(builder.toString());
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
	
	private void showMessageInPopUp(final String message){
		JOptionPane.showMessageDialog(this, message);
	}
	
	private class ViewPanel extends JPanel{
		private JTextArea textArea;
		private JScrollPane scroll;
		public ViewPanel() {
			this.setMinimumSize(vpDim);
			this.setPreferredSize(vpDim);
			this.setMaximumSize(vpDim);
			this.setLayout(new MigLayout("fill","[100%]", "[100%]"));
			textArea = new JTextArea();
			textArea.setEditable(false);
			scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
											JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			this.add(scroll, "grow");
		}
		
		public void showFile(File file) throws IOException{
			textArea.setText(AldebaranUtils.toString(AldebaranUtils.readFile(file), true));
		}
	}
	
}
