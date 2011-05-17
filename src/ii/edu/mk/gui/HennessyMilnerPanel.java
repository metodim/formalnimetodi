package ii.edu.mk.gui;

import ii.edu.mk.hml.hm.HMLexer;
import ii.edu.mk.io.AldebaranFile;
import ii.edu.mk.io.AldebaranUtils;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class HennessyMilnerPanel extends JPanel{

	private final static Logger LOG = LogManager.getLogger(HennessyMilnerPanel.class);
	private final JFrame frameOwner;

	private JTextArea ltsArea = new JTextArea();
	private JTextArea hmlArea = new JTextArea();
	private JLabel statusMessage = new JLabel("Status");
	private JLabel calcStatusMessage = new JLabel("Calculation Status");
	
	private File aldebaranFile;
	
	public HennessyMilnerPanel(final JFrame owner) {
		this.frameOwner = owner;
		
		setLayout(new MigLayout("fill", "[20%]3px[80%]", "[40%]3px[10%]3px[40%]3px[10%]"));
		JLabel ltsContentLabel = new JLabel("LTS (Aldebaran): ");
		JLabel statusMessageLabel = new JLabel("Status: ");
		JLabel hmlLabel = new JLabel("HM Logic: ");

		ltsArea = new JTextArea();
		ltsArea.setFont(Parameters.DEFAULT_TEXT_FIELD_FONT.getValue());
		JScrollPane ltsAreaScrollPane = new JScrollPane(ltsArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ltsAreaScrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		ltsArea.setEnabled(true);
		ltsArea.setEditable(true);

		hmlArea = new JTextArea();
		hmlArea.setFont(Parameters.DEFAULT_TEXT_FIELD_FONT.getValue());
		JScrollPane hmlAreaScrollPane = new JScrollPane(hmlArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		hmlAreaScrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		hmlArea.setEnabled(true);
		hmlArea.setEditable(true);
		
		JButton openLtsExprsButton = new JButton("Open");
		openLtsExprsButton.addActionListener(new OpenLtsAction());
		
		JButton clearLtsAreaButton = new JButton("Clear");
		clearLtsAreaButton.addActionListener(new ClearLtsAreaAction());
		
		JButton calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new CalculateAction());
		
		JButton saveHmlButton = new JButton("Save");
		saveHmlButton.addActionListener(new SaveHmlAction());
		
		add(ltsContentLabel);
		add(ltsAreaScrollPane, "grow, wrap");
		add(statusMessageLabel);

		add(openLtsExprsButton, "split 3, al l");
		add(clearLtsAreaButton, "al r");
		add(statusMessage, "al l, wrap");

		add(hmlLabel);
		add(hmlAreaScrollPane, "grow, wrap");
		add(Box.createVerticalGlue());
		add(saveHmlButton, "split 3, al l");
		add(calculateButton);
		add(calcStatusMessage);
	}
	
	class OpenLtsAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Open LTS (Aldebaran) file...");
			fileChooser.showOpenDialog(frameOwner);
			if (fileChooser.getSelectedFile() != null) {
				aldebaranFile = fileChooser.getSelectedFile();
				try {
					AldebaranFile alFile = AldebaranUtils.readFile(aldebaranFile);
					ltsArea.setText(AldebaranUtils.toString(alFile, true));
					statusMessage.setText("Opened file: " + aldebaranFile.getName());
				} catch (Exception e1) {
					LOG.debug("error reading file:" + e1.getLocalizedMessage());
					statusMessage.setText("Error while trying to read LTS from file");
				}
			}
		}
	}
	
	class ClearLtsAreaAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			clear();
		}
	}
	
	class SaveHmlAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String text = ltsArea.getText().trim();
			if (text != null && !text.isEmpty()) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Save HML in file...");
				fileChooser.showSaveDialog(frameOwner);
				if (fileChooser.getSelectedFile() != null) {
					File fileOut = fileChooser.getSelectedFile();
					try {
						BufferedWriter bufWriter = new BufferedWriter(new FileWriter(fileOut, false));
						bufWriter.write(text);
						bufWriter.flush();
						bufWriter.close();
					} catch (IOException e1) {
						LOG.debug("error writing file:" + e1.getLocalizedMessage());
						statusMessage.setText("Error while trying to write HML to file");
					}
				}
			}
		}
	}
	
	class CalculateAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String hmlExpr = hmlArea.getText().trim();
			if(aldebaranFile != null && hmlExpr != null  && !hmlExpr.isEmpty()){
				HMLexer lexer = new HMLexer(aldebaranFile);
				String result = lexer.tokenization(hmlExpr);
				if(result != null && !result.isEmpty()){
					calcStatusMessage.setText(result);
				}else{
					calcStatusMessage.setText("Can not calculate");
				}
			}else{
				showMessageInPopUp("LTS file must be opened, and expression provided.");
			}
		}
	}
	
	private void clear(){
		aldebaranFile = null;
		ltsArea.setText("");
		hmlArea.setText("");
		statusMessage.setText("");
		calcStatusMessage.setText("");
	}
	
	private void showMessageInPopUp(final String message){
		JOptionPane.showMessageDialog(this, message);
	}
	
}
