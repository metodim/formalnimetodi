package ii.edu.mk.gui;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.UIManager.LookAndFeelInfo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXStatusBar;
import org.joda.time.DateTime;


/**
 * 
 * @author Vladimir Carevski
 */
@SuppressWarnings("serial")
public class MainFrame extends JXFrame {

	private final static Logger LOG = LogManager.getLogger(MainFrame.class);
	
	private JMenuBar menuBar;
//	private JToolBar toolBar;
	private JXStatusBar statusBar;
	
	public MainFrame() {
		super(Parameters.APP_NAME.getValue(), true);
		createMainFrame();
	}

	public void createMainFrame() {

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent evt) {
				exitApplication();
			}
		});

		setScreenSizeAndLocation();

//		menuBar = createMenuBar();
//		toolBar = createToolBar();
		statusBar = buildStatusBar();


//		setJMenuBar(menuBar);
//		setToolBar(toolBar);
		add(statusBar, BorderLayout.SOUTH);
		add(new MainPanel(this));
		ImageIcon icon = Images.APP_ICON_32.loadImageIcon();
		if(icon != null){setIconImage(icon.getImage());}
		applyComponentOrientation(ComponentOrientation.getOrientation(Locale.getDefault()));
		setVisible(true);
	}
	
	protected void setScreenSizeAndLocation(){
		Dimension dim = Parameters.SCREEN_RESOLUTION.getValue();
		if(dim == null){dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();}
		Insets insets = java.awt.Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		dim.width -= insets.left + insets.right;
		dim.height -= insets.bottom + insets.top;
		setMinimumSize(dim);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(screenSize.width / 2 - dim.width / 2, screenSize.height / 2 - dim.height / 2);
		setExtendedState(MAXIMIZED_BOTH);		
	}
	
	
	protected JMenuBar createMenuBar() {
		menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu();
		fileMenu.setText("File");
		JMenuItem exitSubMenu = new JMenuItem(new ExitAction());
		fileMenu.add(exitSubMenu);
		
		JMenu lafMenu = new JMenu();
		lafMenu.setText("L&F");
		
	    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	    	lafMenu.add(new JMenuItem(new ChangeLafAction(info)));
	    }
		
	    JMenu helpMenu = new JMenu("Help");
	    JMenuItem aboutMenuItem = new JMenuItem(new AboutAction());
	    helpMenu.add(aboutMenuItem);
	    
	    
		menuBar.add(fileMenu);
		menuBar.add(lafMenu);
		menuBar.add(helpMenu);
		return menuBar;
	}
	
	class ChangeLafAction extends AbstractAction{
		LookAndFeelInfo lafi;
		public ChangeLafAction(LookAndFeelInfo lafi) {
			this.lafi = lafi;
			putValue(Action.NAME, lafi.getName());
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(lafi != null){setLookAndFeel(lafi);}
		}
	}
	
	private void setLookAndFeel(LookAndFeelInfo info){
		try{
			UIManager.setLookAndFeel(info.getClassName());
			SwingUtilities.updateComponentTreeUI(this);
		}catch (Exception ex) {
			LOG.debug("Error setting Look and feel:" + info.getName());
		}
	}
	
	class ExitAction extends AbstractAction{
		public ExitAction() {
			putValue(Action.NAME, "Exit");
		}
		@Override
		public void actionPerformed(ActionEvent paramActionEvent) {
			exitApplication();
		}
	}

	public void exitApplication() {
		try {
			//TODO gracefully close everything
			dispose();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
	
	class AboutAction extends AbstractAction{
		
		public AboutAction() {
			putValue(Action.NAME, "About...");
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		}
	}
	
	protected JXStatusBar buildStatusBar() {

		JXStatusBar statusBar = new JXStatusBar();			
		Package mPack = getClass().getPackage();
		JLabel statusLabel;
		if (mPack.getImplementationVendor() == null
				|| mPack.getImplementationTitle() == null
				|| mPack.getImplementationVersion() == null) {
			// case where manifest file is not accessible
			statusLabel = new JLabel(String.format("%s (%s)", Parameters.APP_NAME.getValue(), Locale.getDefault()));
		} else {
			statusLabel = new JLabel(String.format("%s - %s (%s) V%s", mPack.getImplementationVendor(), mPack.getImplementationTitle(), Locale.getDefault(), mPack.getImplementationVersion()));
		}

		JXStatusBar.Constraint cStatusLabel = new JXStatusBar.Constraint();
		cStatusLabel.setFixedWidth(400);
		statusBar.add(statusLabel, cStatusLabel);

		JXStatusBar.Constraint fillConstraint = new JXStatusBar.Constraint(
				JXStatusBar.Constraint.ResizeBehavior.FILL);
		statusBar.add(new JLabel(""), fillConstraint);

		JXStatusBar.Constraint memoryConstraint = new JXStatusBar.Constraint();
		memoryConstraint.setFixedWidth(220);
		MemoryLabel memoryLabel = new MemoryLabel();
		statusBar.add(memoryLabel, memoryConstraint);
		Timer statusBarMemory = new Timer(1000, memoryLabel);
		statusBarMemory.start();

		JXStatusBar.Constraint timerConstraint = new JXStatusBar.Constraint();
		timerConstraint.setFixedWidth(200);
		TimerLabel timerLabel = new TimerLabel();
		statusBar.add(timerLabel, timerConstraint);
		Timer statusBarTimer = new Timer(1000, timerLabel);
		statusBarTimer.start();

		return statusBar;
	}
	
	private static class TimerLabel extends JLabel implements ActionListener {
		private static final long serialVersionUID = 1L;
		DateTime dateTime;
		public void actionPerformed(ActionEvent e) {
			dateTime = new DateTime();
			this.setText(dateTime.toString("dd-mm-YYYY") + dateTime.toString(" HH:mm:ss"));
		}
	}
	private static class MemoryLabel extends JLabel implements ActionListener {
		private static final long serialVersionUID = 1L;
		Runtime runtime = Runtime.getRuntime();
		public void actionPerformed(ActionEvent e) {
            long freeMemory  = runtime.freeMemory();
            long totalMemory = runtime.totalMemory();
            long total = totalMemory / (1024*1024);
            long used  = (totalMemory - freeMemory) / (1024*1024);
			this.setText(String.format("Mem %s/%s Mb (max %sMb)", used, total, runtime.maxMemory()/(1024*1024)));
		}
	}
}