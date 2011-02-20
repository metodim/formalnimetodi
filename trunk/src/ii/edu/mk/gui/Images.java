package ii.edu.mk.gui;


import javax.swing.ImageIcon;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public enum Images {

	SPLASH("ii.jpg", "II Informatics Logo"),
	APP_ICON_32("ii_32.jpg", "II Logo");
	
	private String imageName;
	private String imageDescription;
	private final static Logger LOG = LogManager.getLogger(Images.class);
	
	private Images(String imageName, String description) {
		this.imageName = imageName;
		this.imageDescription = description;
	}
	
	public String getImageName() {
		return imageName;
	}
	
	public ImageIcon loadImageIcon() {
		try {
			ClassLoader classloader = this.getClass().getClassLoader();
			java.net.URL url = classloader.getResource(Parameters.RESOURCE_PATH.getValue() + imageName);
			ImageIcon icon = new ImageIcon(url, imageDescription);
			return icon;
		} catch (Exception e) {
			e.printStackTrace();
			LOG.warn(String.format("invalid url: s% \n s%" , imageName, e.getMessage()));
		}

		return null;
	}
	
}
