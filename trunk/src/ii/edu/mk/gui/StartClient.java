package ii.edu.mk.gui;


import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;

import javax.swing.RepaintManager;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class StartClient {

	private static SplashScreen splashScreen;

	private final static Logger LOG = LogManager.getLogger(StartClient.class);

	public static void main(String[] args) {
		
//		if (args.length != 1) {
//			LOG.error(ClientConstants);
//			System.exit(0);
//		}
		StartClient clientLauncher = new StartClient();
		clientLauncher.init("");
	}

	private void init(String serverUrl) {

		//let EDT start the splash screen
		try {
			EventQueue.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					splashScreen  = new SplashScreen();
					splashScreen.display();
				}
			});
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		}
		
		if(LOG.isDebugEnabled()){
			LOG.info("Thread violation repaint manager enabled.");
			RepaintManager.setCurrentManager(new CheckThreadViolationRepaintManager());
		}
		
		//let EDT initialize and show the main frame
		try {
			EventQueue.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					MainFrame mainFrame = new MainFrame();
					mainFrame.pack();
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//let EDT kill the splash screen
		try {
			EventQueue.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					if (splashScreen != null) {
						splashScreen.dispose();
					}
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}