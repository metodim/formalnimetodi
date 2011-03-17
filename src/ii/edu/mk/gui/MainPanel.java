package ii.edu.mk.gui;

import ii.edu.mk.parser.Ccs1Lexer;
import ii.edu.mk.parser.Ccs1Parser;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import net.miginfocom.swing.MigLayout;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.jdesktop.swingx.JXPanel;

/**
 * Initialize and layout the components of the content panel here.
 * @author carevski
 */
@SuppressWarnings("serial")
public class MainPanel extends JXPanel{

	private JTabbedPane tabbedPane;
	
	public MainPanel() {
		initComponents();
		this.setLayout(new MigLayout("fill"));
		drawLayout();
	}
	
	private void initComponents(){
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Parser", createParserTab());
	}
	
	private JPanel createParserTab(){
		JPanel parserPanel = new JPanel(new MigLayout("fill", "[20%]3px[80%]","[45%]3px[10%]3px[45%]"));
		JLabel testExpresionLabel = new JLabel("Test Expression:");
		JLabel parseStatusLabel = new JLabel("Parse Status:");
		JLabel parseStatusMessageLabel = new JLabel("Status Message");
		JLabel expressionTokensLabel = new JLabel("Expression Tokens:");
		
		JTextArea testExpressionArea = new JTextArea(500,50);
		testExpressionArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		testExpressionArea.setEnabled(true);
		testExpressionArea.setEditable(true);

		JTextArea tokenExpressionArea = new JTextArea(500,50);
		tokenExpressionArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tokenExpressionArea.setEnabled(true);
		tokenExpressionArea.setEditable(false);
		
		JButton parserButton = new JButton("Parse");
		parserButton.addActionListener(new ParserButtonAction(testExpressionArea, tokenExpressionArea, parseStatusMessageLabel));
		
		parserPanel.add(testExpresionLabel);
		parserPanel.add(new JScrollPane(testExpressionArea, 20, 30), "wrap");
		parserPanel.add(parseStatusLabel);
		parserPanel.add(parseStatusMessageLabel, "split 2, al l");
		parserPanel.add(parserButton, "al r, wrap");
		parserPanel.add(expressionTokensLabel);
		parserPanel.add(new JScrollPane(tokenExpressionArea, 20, 30));
		return parserPanel;
	}
	
	class ParserButtonAction implements ActionListener{
		JTextArea inputField;
		JTextArea outputField;
		JLabel statusMessage;
		public ParserButtonAction(JTextArea inField, JTextArea outField, JLabel status) {
			inputField = inField; outputField = outField; statusMessage = status;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String testExprsStr = inputField.getText();
			String testExprs[] = testExprsStr.split("\n");
			outputField.setText("");
			statusMessage.setText("");
			boolean success = true;
			for(String expr : testExprs){
				try{
				    Ccs1Lexer lex = new Ccs1Lexer(new ANTLRStringStream(expr));
				    CommonTokenStream tokens = new CommonTokenStream(lex);
				    Ccs1Parser parser = new Ccs1Parser(tokens);
				    CommonTree root = (CommonTree)parser.expr().getTree();
				    for(int i = 0; i<root.getChildCount(); i++){
				    	CommonTree child = (CommonTree) root.getChildren().get(i);
				    	outputField.append(child.getText());
				    	if(i < root.getChildCount() - 1){
				    		outputField.append(",");
				    	}
				    }
				    outputField.append("\n");
				}catch (RecognitionException recex) {
					success = false; break;
				}catch (RuntimeException runex) {
					success = false; break;
				}
			}
			if(success){
				statusMessage.setText("Success");
			}else{
				statusMessage.setText("Failed");
			}
		}
	}
	
	private void drawLayout(){
		this.add(tabbedPane, "grow");
	}
	
}
