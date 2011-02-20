package ii.edu.mk.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;

import net.miginfocom.swing.MigLayout;

import org.jdesktop.swingx.JXPanel;

/**
 * Initialize and layout the components of the content panel here.
 * @author carevski
 */
@SuppressWarnings("serial")
public class MainPanel extends JXPanel{

	private JButton fileChooserButton;
	private JFileChooser fileChooser;
	
	public MainPanel() {
		initComponents();
		addFileChooserAction();
		this.setLayout(new MigLayout());
		drawLayout();
	}
	
	private void initComponents(){
		fileChooserButton = new JButton("File");
		fileChooser = new JFileChooser();
	}
	
	private void addFileChooserAction(){
		fileChooserButton.addActionListener(new ShowOpenDialogAction(this));
	}
	
	class ShowOpenDialogAction implements ActionListener{
		private JComponent ownerComp;
		public ShowOpenDialogAction(JComponent owner) {
			this.ownerComp = owner;
		}
		@Override
		public void actionPerformed(ActionEvent paramActionEvent) {
			fileChooser.showOpenDialog(ownerComp);
		}
	}
	
	private void drawLayout(){
		this.add(fileChooserButton);
	}
	
}
