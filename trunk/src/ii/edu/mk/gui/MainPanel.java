package ii.edu.mk.gui;

import javax.swing.JTabbedPane;

import net.miginfocom.swing.MigLayout;

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
		tabbedPane.addTab("CCS to LTS", new CcsToLtsPanel());
		tabbedPane.addTab("Bisimulation", new BisimulationPanel());
	}
	
	private void drawLayout(){
		this.add(tabbedPane, "grow");
	}
	
}
