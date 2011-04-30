package ii.edu.mk.gui;


import java.io.ByteArrayOutputStream;
import java.io.InputStream;

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
			//note (CV): should work within jar file
			ClassLoader classloader = this.getClass().getClassLoader();
			InputStream inputStream = classloader.getResourceAsStream(Parameters.RESOURCE_PATH.getValue() + imageName);
			if(inputStream != null){
				ByteArrayOutputStream baroStream = new ByteArrayOutputStream();
				int c;
				while ((c = inputStream.read()) != -1) {
					baroStream.write((char) c);}
				return new ImageIcon(baroStream.toByteArray(), imageDescription);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			LOG.warn(String.format("invalid input strem: s% \n s%" , imageName, e.getMessage()));
		}

		return null;
	}
	
}
