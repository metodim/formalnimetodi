package ii.edu.mk.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;

/**
 * 
 * @author Vladimir Carevski
 */
@SuppressWarnings("serial")
public class CcsToLtsPanel extends JPanel {

	JTextArea expressionArea;
	JTextArea ltsArea;
	
	public CcsToLtsPanel() {
		setLayout(new MigLayout("fill", "[20%]3px[80%]","[40%]3px[10%]3px[40%]3px[10%]"));
		JLabel testExpresionLabel = new JLabel("CCS Expression:");
		JLabel parseStatusLabel = new JLabel("LTS Status:");
		JLabel parseStatusMessageLabel = new JLabel("Status Message");
		JLabel expressionTokensLabel = new JLabel("LTS (Aldebaran format):");
		
		expressionArea = new JTextArea();
		JScrollPane testExpressionScrollPane = new JScrollPane(expressionArea, 20, 30);
		testExpressionScrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		expressionArea.setEnabled(true);
		expressionArea.setEditable(true);
		JButton clearExpressionArea = new JButton("Clear");
		clearExpressionArea.addActionListener(new ClearExpressionAreaAction());
		
		ltsArea = new JTextArea();
		JScrollPane ltsAreaScrollPane = new JScrollPane(ltsArea, 20, 30);
		ltsAreaScrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		ltsArea.setEnabled(true);
		ltsArea.setEditable(false);
		JButton clearLtsAreaButton = new JButton("Clear");
		clearExpressionArea.addActionListener(new ClearLtsAreaAction());
		
		JButton saveLtsButton = new JButton("Save");
		saveLtsButton.addActionListener(new SaveLtsAction(this));
		
		JButton parserButton = new JButton("Generate LTS");
		parserButton.addActionListener(new GenerateLTSAction(expressionArea, ltsArea, parseStatusMessageLabel));
		
		add(testExpresionLabel);
		add(testExpressionScrollPane, "grow, wrap");
		add(parseStatusLabel);
		add(parserButton, "split 3, al l");
		add(clearExpressionArea, "al r");
		add(parseStatusMessageLabel, "al l, wrap");
		add(expressionTokensLabel);
		add(ltsAreaScrollPane, "grow, wrap");
		add(Box.createVerticalGlue());
		add(saveLtsButton, "split 2");
		add(clearLtsAreaButton);
	}
	
	class GenerateLTSAction implements ActionListener{
		JTextArea inputField;
		JTextArea outputField;
		JLabel statusMessage;
		public GenerateLTSAction(JTextArea inField, JTextArea outField, JLabel status) {
			inputField = inField; outputField = outField; statusMessage = status;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
		}
	}
	
	class ClearExpressionAreaAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			expressionArea.setText("");
		}
	}
	
	class ClearLtsAreaAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ltsArea.setText("");
		}
	}
	
	class SaveLtsAction implements ActionListener {
		JComponent parent = null;
		public SaveLtsAction(JComponent parentComponent) {
			parent = parentComponent;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			String ltsText = ltsArea.getText().trim();
			if(ltsText != null && !ltsText.isEmpty() ){
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Save LTS in file...");
				fileChooser.showSaveDialog(parent);
				if(fileChooser.getSelectedFile() != null){
					File fileOut = fileChooser.getSelectedFile();
					System.out.println(fileOut.getAbsolutePath());
				}
			}
		}
	}
}
