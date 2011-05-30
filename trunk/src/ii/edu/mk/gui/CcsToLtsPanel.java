package ii.edu.mk.gui;

import ii.edu.mk.ccs.SosGraphNode;
import ii.edu.mk.ccs.SosRule;
import ii.edu.mk.ccs.SosTransformer;
import ii.edu.mk.ccs.SosTransformerException;
import ii.edu.mk.ccs.domain.CcsDefinition;
import ii.edu.mk.ccs.domain.base.CcsOperation;
import ii.edu.mk.io.AldebaranFile;
import ii.edu.mk.io.AldebaranUtils;
import ii.edu.mk.parser.ASTDomainBuilder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
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
import javax.swing.JDialog;
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

	private final JXFrame frame;

	JTextArea expressionArea;
	JTextArea stateToCcsArea;
	JTextArea ltsArea;
	JTextArea aldebaranArea;
	JLabel parseStatusMessageLabel;

	SosGraphNode ltsRootNode;
	AldebaranFile aldebaranFile;
	File ccsFile;

	LtsGraphPanel aldebaranGraphPanel;
	SosTransformationGraphPanel ltsGraphPanel;

	JDialog aldebaranDialog;
	JDialog ltsDialog;

	public CcsToLtsPanel(final JXFrame frameOwner) {
		this.frame = frameOwner;

		setLayout(new MigLayout("fill", "[20%]3px[40%]3px[40%]", "[40%]3px[10%]3px[40%]3px[10%]"));
		JLabel testExpresionLabel = new JLabel("CCS Expression:");
		JLabel parseStatusLabel = new JLabel("LTS Status:");
		parseStatusMessageLabel = new JLabel("Status Message");
		parseStatusMessageLabel.setFont(Parameters.DEFAULT_TEXT_FIELD_FONT.getValue());
		JLabel expressionTokensLabel = new JLabel("LTS (Aldebaran format):");

		expressionArea = new JTextArea();
		expressionArea.setFont(Parameters.DEFAULT_TEXT_FIELD_FONT.getValue());
		stateToCcsArea = new JTextArea();
		stateToCcsArea.setFont(Parameters.DEFAULT_TEXT_FIELD_FONT.getValue());
		JScrollPane testExpressionScrollPane = new JScrollPane(expressionArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		testExpressionScrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		JScrollPane stateToCcsExpressionScrollPane = new JScrollPane(stateToCcsArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		stateToCcsExpressionScrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		expressionArea.setEnabled(true);
		expressionArea.setEditable(true);
		stateToCcsArea.setEnabled(true);
		stateToCcsArea.setEditable(true);
		JButton clearExpressionArea = new JButton("Clear");
		clearExpressionArea.addActionListener(new ClearExpressionAreaAction());

		aldebaranArea = new JTextArea();
		aldebaranArea.setFont(Parameters.DEFAULT_TEXT_FIELD_FONT.getValue());

		ltsArea = new JTextArea();
		ltsArea.setFont(Parameters.DEFAULT_TEXT_FIELD_FONT.getValue());

		JScrollPane aldebaranScrollPane = new JScrollPane(aldebaranArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		aldebaranScrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JScrollPane ltsScrollPane = new JScrollPane(ltsArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ltsScrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		aldebaranArea.setEnabled(true);
		aldebaranArea.setEditable(false);
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

		JButton viewLtsGraphButton = new JButton("View LTS Graph");
		viewLtsGraphButton.addActionListener(new ViewLtsGraphAction());

		JButton viewSosTransfGraphButton = new JButton("View Transf. Graph");
		viewSosTransfGraphButton.addActionListener(new ViewSosTransformationGraphAction());

		JButton parserButton = new JButton("Generate LTS");
		parserButton.addActionListener(new GenerateLTSAction(expressionArea, ltsArea, parseStatusMessageLabel));

		add(testExpresionLabel);
		add(testExpressionScrollPane, "grow");
		add(stateToCcsExpressionScrollPane, "grow, wrap");
		add(parseStatusLabel);

		add(openCcsExprsButton, "split 5, al l");
		add(saveCcsExprsButton, "al l");
		add(clearExpressionArea, "al r");
		add(parserButton, "al l");
		add(viewSosTransfGraphButton, "al r");
		add(parseStatusMessageLabel, "al l, wrap");

		add(expressionTokensLabel);
		add(aldebaranScrollPane, "grow");
		add(ltsScrollPane, "grow, wrap");
		add(Box.createVerticalGlue());
		add(saveLtsButton, "split 3");
		add(viewLtsGraphButton);
		add(clearLtsAreaButton);

		aldebaranGraphPanel = new LtsGraphPanel();
		aldebaranDialog = new JDialog(this.frame, true);
		aldebaranDialog.setTitle("LTS Graph");
		aldebaranDialog.setContentPane(aldebaranGraphPanel);

		ltsGraphPanel = new SosTransformationGraphPanel();
		ltsDialog = new JDialog(this.frame, true);
		ltsDialog.setTitle("SOS Transformation Graph");
		ltsDialog.setContentPane(ltsGraphPanel);
	}

	class GenerateLTSAction implements ActionListener {
		JTextArea inputField;
		JTextArea outputField;
		JLabel statusMessage;

		public GenerateLTSAction(JTextArea inField, JTextArea outField, JLabel status) {
			inputField = inField;
			outputField = outField;
			statusMessage = status;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			clearLtsGraph();
			try {
				List<String> expressions = getExpressionsStrings(expressionArea.getText());
				if (expressions.size() == 0)
					return;
				List<CcsOperation> ccsOperations = new ArrayList<CcsOperation>();
				for (String expression : expressions) {
					ccsOperations.add(ASTDomainBuilder.INSTANCE.getRoot(expression));
				}

				if (ccsOperations.size() > 1 && !checkCcsDefinitions(ccsOperations)) {
					parseStatusMessageLabel.setText("CCS expresssion definition error");
					return;
				}

				ltsRootNode = SosTransformer.getInstance().generateLtsGraph(ccsOperations).get(0);
				aldebaranFile = AldebaranUtils.convert(ltsRootNode);
				aldebaranArea.setText(AldebaranUtils.toString(aldebaranFile, true));
				ltsArea.setText(print(ltsRootNode));
				stateToCcsArea.setText(stateToCcs(ltsRootNode));
			} catch (SosTransformerException ste) {
				LOG.debug("sos transformer exception:" + ste.getLocalizedMessage());
				parseStatusMessageLabel.setText(ste.getLocalizedMessage());
			} catch (RecognitionException ex) {
				LOG.debug("exception:" + ex.getLocalizedMessage());
				parseStatusMessageLabel.setText("Error in parsing the ccs expressions");
			} catch (Exception ex) {
				LOG.debug("exception:" + ex.getLocalizedMessage());
				parseStatusMessageLabel.setText("Error in generation");
			}
		}
	}

	private String stateToCcs(SosGraphNode ltsRootNode) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ltsRootNode.getTotalNodesInGraph(); i++) {
			sb.append(i);
			sb.append(":");
			sb.append(ltsRootNode.getOrderNumberToGraphNode().get(i).getCcsTree().toString());
			sb.append("\n");
		}

		return sb.toString();
	}

	private String print(SosGraphNode graph) {
		StringBuilder sb = new StringBuilder();
		sb.append(graph.getName()).append(": ").append(graph.getCcsTree()).append("\n");
		print(graph, "", 1, sb);
		return sb.toString();
	}

	List<SosGraphNode> visited = new ArrayList<SosGraphNode>();

	private String print(SosGraphNode graph, String prefix, int level, StringBuilder sb) {
		if (graph.getTransitions().keySet().size() == 0)
			return sb.toString();

		if (visited.contains(graph))
			return sb.toString();

		visited.add(graph);
		for (SosRule sosRule : graph.getTransitions().keySet()) {
			SosGraphNode next = graph.getTransitions().get(sosRule);

			sb.append(prefix).append("\t").append(sosRule.getSymbol()).append("\t").append(next.getName()).append(": ").append(next.getCcsTree());
			sb.append("\n");

			if (!next.isForestRoot())
				print(next, prefix + "\t\t\t", level + 1, sb);
		}

		return sb.toString();
	}

	private List<String> getExpressionsStrings(String text) {
		List<String> expressionsList = new ArrayList<String>();
		String[] expressions = text.split("\n+");
		for (String expr : expressions) {
			String expr1 = expr.trim();
			if (expr1 != null && !expr.isEmpty()) {
				expressionsList.add(expr1);
			}
		}
		return expressionsList;
	}

	private boolean checkCcsDefinitions(List<CcsOperation> ccsOperations) {
		for (CcsOperation rootOperation : ccsOperations) {
			if (!(rootOperation instanceof CcsDefinition))
				return false;
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

	private void clearLtsGraph() {
		ltsRootNode = null;
		aldebaranFile = null;
		aldebaranArea.setText("");
		ltsArea.setText("");
		stateToCcsArea.setText("");
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
			if (ltsText != null && !ltsText.isEmpty()) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Save LTS in file...");
				fileChooser.showSaveDialog(parent);
				if (fileChooser.getSelectedFile() != null) {
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
			if (fileChooser.getSelectedFile() != null) {
				ccsFile = fileChooser.getSelectedFile();
				try {
					BufferedReader reader = new BufferedReader(new FileReader(ccsFile));
					StringBuilder stringBuilder = new StringBuilder();
					String line = null;
					while ((line = reader.readLine()) != null)
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
			if (ccsText != null && !ccsText.isEmpty()) {
				if (ccsFile == null) {
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setDialogTitle("Save CCS expressions in file...");
					fileChooser.showSaveDialog(parent);
					ccsFile = fileChooser.getSelectedFile();
				}
				if (ccsFile != null) {
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

	class ViewLtsGraphAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (aldebaranFile != null) {
				aldebaranGraphPanel.drawGraph(aldebaranFile);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				aldebaranDialog.setLocation((dim.width / 2) - (LtsGraphPanel.VP_DIM.width / 2), (dim.height / 2) - (LtsGraphPanel.VP_DIM.height / 2));
				aldebaranDialog.pack();
				aldebaranDialog.setVisible(true);
			} else {
				LOG.debug("aldebaran file is null.");
			}
		}
	}

	class ViewSosTransformationGraphAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (ltsRootNode != null) {
				ltsGraphPanel.drawGraph(ltsRootNode);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				ltsDialog.setLocation((dim.width / 2) - (SosTransformationGraphPanel.VP_DIM.width / 2), (dim.height / 2) - (SosTransformationGraphPanel.VP_DIM.height / 2));
				ltsDialog.pack();
				ltsDialog.setVisible(true);
			} else {
				LOG.debug("lts root node is null.");
			}
		}
	}
}
