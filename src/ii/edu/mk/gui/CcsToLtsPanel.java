package ii.edu.mk.gui;

import ii.edu.mk.ccs.SosGraphNode;
import ii.edu.mk.ccs.SosTransformer;
import ii.edu.mk.ccs.SosTransformerException;
import ii.edu.mk.ccs.domain.CcsDefinition;
import ii.edu.mk.ccs.domain.base.CcsOperation;
import ii.edu.mk.io.AldebaranFile;
import ii.edu.mk.io.AldebaranUtils;
import ii.edu.mk.parser.ASTDomainBuilder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

import org.antlr.runtime.RecognitionException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 
 * @author Vladimir Carevski
 */
@SuppressWarnings("serial")
public class CcsToLtsPanel extends JPanel {

	private final static Logger LOG = LogManager.getLogger(CcsToLtsPanel.class);
	
	JTextArea expressionArea;
	JTextArea ltsArea;
	JLabel parseStatusMessageLabel;
	
	SosGraphNode rootNode;
	AldebaranFile aldebaranFile;
	
	public CcsToLtsPanel() {
		setLayout(new MigLayout("fill", "[20%]3px[80%]","[40%]3px[10%]3px[40%]3px[10%]"));
		JLabel testExpresionLabel = new JLabel("CCS Expression:");
		JLabel parseStatusLabel = new JLabel("LTS Status:");
		parseStatusMessageLabel = new JLabel("Status Message");
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
			try {
				List<String> expressions = getExpressionsStrings(expressionArea.getText());
				List<CcsOperation> ccsOperations = new ArrayList<CcsOperation>();
				for(String expression : expressions){
					ccsOperations.add(ASTDomainBuilder.INSTANCE.getRootNoRecursion(expression));
				}
				
				if(ccsOperations.size()>1 && !checkCcsDefinitions(ccsOperations)){
					parseStatusMessageLabel.setText("CCS expresssion definition error");
					return;
				}
				
				rootNode = SosTransformer.getInstance().generateLtsGraph(ccsOperations);
				aldebaranFile = AldebaranUtils.convert(rootNode);
				ltsArea.setText(AldebaranUtils.toString(aldebaranFile, true));
			} catch (SosTransformerException ste){
				LOG.debug("sos transformer exception:" + ste.getLocalizedMessage());
				parseStatusMessageLabel.setText(ste.getLocalizedMessage());
			} catch (RecognitionException ex){
				LOG.debug("exception:" + ex.getLocalizedMessage());
				parseStatusMessageLabel.setText("Error in parsing the ccs expressions");
			} catch (Exception ex) {
				LOG.debug("exception:" + ex.getLocalizedMessage());
				parseStatusMessageLabel.setText("Error in generation");
			}
		}
	}
	
	private List<String> getExpressionsStrings(String text){
		List<String> expressionsList = new ArrayList<String>();
		String[] expressions = text.split("\n+");
		for(String expr : expressions){
			String expr1 = expr.trim();
			if(expr1 != null && !expr.isEmpty()){
				expressionsList.add(expr1);
			}
		}
		return expressionsList;
	}
	
	private boolean checkCcsDefinitions(List<CcsOperation> ccsOperations){
		for(CcsOperation rootOperation : ccsOperations){
			if(!(rootOperation instanceof CcsDefinition)) return false;
		}
		return true;
	}
	
	class ClearExpressionAreaAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			expressionArea.setText("");
			clearLtsGraph();
		}
	}
	
	class ClearLtsAreaAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			clearLtsGraph();
		}
	}
	
	private void clearLtsGraph(){
		rootNode = null;
		aldebaranFile = null;
		ltsArea.setText("");
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
					try {
						AldebaranUtils.writeFile(aldebaranFile, fileOut);
					} catch (IOException e1) {
						LOG.debug("error writing file:" + e1.getLocalizedMessage());
						parseStatusMessageLabel.setText("Error while trying to write LTS to file");
					}
				}
			}
		}
	}
}
