package ii.edu.mk.io;

import ii.edu.mk.gui.Parameters;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 
 * @author Vladimir Carevski
 */
public class BaseIOTest {

	private static final String folderPath = "test" + File.separator + Parameters.RESOURCE_PATH.getValue();
	
	protected String getTestResourceFileContent(String fileName) throws IOException{
		ClassLoader classloader = this.getClass().getClassLoader();
		InputStream inputStream = classloader.getResourceAsStream(folderPath + fileName);
		if(inputStream != null){
			int c;
			ByteArrayOutputStream baroStream = new ByteArrayOutputStream();
			while ((c = inputStream.read()) != -1) baroStream.write((char) c);
			return baroStream.toString();
		}
		return null;
	}
	
	protected File getTestResourceFile(String fileName) throws IOException{
		ClassLoader classloader = this.getClass().getClassLoader();
		String fileNameStr = folderPath + fileName;
		URL url = classloader.getResource(fileNameStr);
		File file = null;
		if(url == null){
			file =  new File(fileNameStr);
			if(!file.exists()){file.createNewFile();}
		}else{
			file = new File(url.getFile());
		}
		return file;
	}
}
