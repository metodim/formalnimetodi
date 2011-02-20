package ii.edu.mk.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;


public class SplashScreen extends JWindow {

	private static final long serialVersionUID = 1L;
	private final long waitTime = 1000;
	private long startTime = 0;

	public SplashScreen() {}

	public void display() {
		startTime = System.currentTimeMillis();

		ImageIcon icon = Images.SPLASH.loadImageIcon();
		if (icon == null) {
			return;
		}

		JLabel label = new JLabel(icon);
		label.setBorder(BorderFactory.createLineBorder(java.awt.Color.black));
		getContentPane().add(label, BorderLayout.CENTER);
		pack();

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				startTime = 0;
				setVisible(false);
				dispose();
			}
		});

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension labelSize = label.getPreferredSize();
		setLocation(screenSize.width / 2 - labelSize.width / 2, 
				screenSize.height / 2 - labelSize.height / 2);
		setVisible(true);
	}


	@Override
	public void dispose() {
		if (startTime > 0) {
			try {
				long current = System.currentTimeMillis();
				if ((current - startTime) < waitTime) {
					Thread.sleep(waitTime - (current - startTime));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		super.dispose();
	}
}