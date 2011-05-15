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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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
import org.jdesktop.swingx.JXFrame;

/**
 * 
 * @author Vladimir Carevski
 */
@SuppressWarnings("serial")
public class CcsToLtsPanel extends JPanel {

	private final static Logger LOG = LogManager.getLogger(CcsToLtsPanel.class);
	
	@SuppressWarnings("unused")
	private final JXFrame frame;
	
	JTextArea expressionArea;
	JTextArea ltsArea;
	JLabel parseStatusMessageLabel;
	
	SosGraphNode rootNode;
	AldebaranFile aldebaranFile;
	File ccsFile;
	
	public CcsToLtsPanel(final JXFrame frameOwner) {
		this.frame = frameOwner;
		
		setLayout(new MigLayout("fill", "[20%]3px[80%]","[40%]3px[10%]3px[40%]3px[10%]"));
		JLabel testExpresionLabel = new JLabel("CCS Expression:");
		JLabel parseStatusLabel = new JLabel("LTS Status:");
		parseStatusMessageLabel = new JLabel("Status Message");
		parseStatusMessageLabel.setFont(Parameters.DEFAULT_TEXT_FIELD_FONT.getValue());
		JLabel expressionTokensLabel = new JLabel("LTS (Aldebaran format):");
		
		expressionArea = new JTextArea();
		expressionArea.setFont(Parameters.DEFAULT_TEXT_FIELD_FONT.getValue());
		JScrollPane testExpressionScrollPane = new JScrollPane(expressionArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		testExpressionScrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		expressionArea.setEnabled(true);
		expressionArea.setEditable(true);
		JButton clearExpressionArea = new JButton("Clear");
		clearExpressionArea.addActionListener(new ClearExpressionAreaAction());
		
		ltsArea = new JTextArea();
		ltsArea.setFont(Parameters.DEFAULT_TEXT_FIELD_FONT.getValue());
		JScrollPane ltsAreaScrollPane = new JScrollPane(ltsArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ltsAreaScrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		ltsArea.setEnabled(true);
		ltsArea.setEditable(false);
		JButton clearLtsAreaButton = new JButton("Clear");
		clearExpressionArea.addActionListener(new ClearLtsAreaAction());
		
		JButton openCcsExprsButton = new JButton("Open");
		openCcsExprsButton.addActionListener(new OpenCcsAction(this));
		
		JButton saveCcsExprsButton = new JButton("Save");
		saveCcsExprsButton.addActionListener(new SaveCcsAction(this));
		
		JButton saveLtsButton = new JButton("Save");
		saveLtsButton.addActionListener(new SaveLtsAction(this));
		
		JButton parserButton = new JButton("Generate LTS");
		parserButton.addActionListener(new GenerateLTSAction(expressionArea, ltsArea, parseStatusMessageLabel));
		
		add(testExpresionLabel);
		add(testExpressionScrollPane, "grow, wrap");
		add(parseStatusLabel);
		
		add(openCcsExprsButton, "split 5, al l");
		add(saveCcsExprsButton, "al l");
		add(clearExpressionArea, "al r");
		add(parserButton, "al l");
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
				if(expressions.size() == 0) return;
				List<CcsOperation> ccsOperations = new ArrayList<CcsOperation>();
				for(String expression : expressions){
					ccsOperations.add(ASTDomainBuilder.INSTANCE.getRoot(expression));
				}
				
				if(ccsOperations.size()>1 && !checkCcsDefinitions(ccsOperations)){
					parseStatusMessageLabel.setText("CCS expresssion definition error");
					return;
				}

				rootNode = SosTransformer.getInstance().generateLtsGraph(ccsOperations).get(0);
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
			ccsFile = null;
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
		parseStatusMessageLabel.setText("");
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
	
	class OpenCcsAction implements ActionListener {
		JComponent parent = null;
		public OpenCcsAction(JComponent parentComponent) {
			parent = parentComponent;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Open CCS expressions from file...");
			fileChooser.showOpenDialog(parent);
			if(fileChooser.getSelectedFile() != null){
				ccsFile = fileChooser.getSelectedFile();
				try {
					BufferedReader reader = new BufferedReader(new FileReader(ccsFile));
					StringBuilder stringBuilder = new StringBuilder();
					String line = null;
					while( (line = reader.readLine()) != null)
						stringBuilder.append(line).append("\n");
					expressionArea.setText(stringBuilder.toString());
					parseStatusMessageLabel.setText("Opened file: " + ccsFile.getName());
				} catch (IOException e1) {
					LOG.debug("error reading file:" + e1.getLocalizedMessage());
					parseStatusMessageLabel.setText("Error while trying to read CCS expressions from file");
				}
			}
		}
	}
	
	class SaveCcsAction implements ActionListener {
		JComponent parent = null;
		public SaveCcsAction(JComponent parentComponent) {
			parent = parentComponent;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			String ccsText = expressionArea.getText().trim();
			if(ccsText != null && !ccsText.isEmpty() ){
				if(ccsFile == null){
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setDialogTitle("Save CCS expressions in file...");
					fileChooser.showSaveDialog(parent);
					ccsFile = fileChooser.getSelectedFile();
				}
				if(ccsFile != null){
					try {
						PrintWriter writer = new PrintWriter(ccsFile);
						writer.print(ccsText);
						writer.flush();
						writer.close();
						parseStatusMessageLabel.setText("Saved in file: " + ccsFile.getName());
					} catch (IOException e1) {
						LOG.debug("error writing file:" + e1.getLocalizedMessage());
						parseStatusMessageLabel.setText("Error while trying to write LTS to file");
					}
				}
			}
		}
	}
}
