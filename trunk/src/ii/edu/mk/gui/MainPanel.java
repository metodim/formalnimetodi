package ii.edu.mk.gui;

import javax.swing.JTabbedPane;

import net.miginfocom.swing.MigLayout;

import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXPanel;

/**
 * Initialize and layout the components of the content panel here.
 * @author carevski
 */
@SuppressWarnings("serial")
public class MainPanel extends JXPanel{

	private JXFrame owner;
	private JTabbedPane tabbedPane;
	
	public MainPanel(MainFrame owner) {
		this.owner = owner;
		initComponents();
		this.setLayout(new MigLayout("fill"));
		drawLayout();
	}
	
	private void initComponents(){
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("CCS to LTS", new CcsToLtsPanel(owner));
		tabbedPane.addTab("Bisimulation", new BisimulationPanel(owner));
	}
	
	private void drawLayout(){
		this.add(tabbedPane, "grow");
	}
	
}
