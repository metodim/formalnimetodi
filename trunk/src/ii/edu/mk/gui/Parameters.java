package ii.edu.mk.gui;

import java.awt.Dimension;
import java.io.File;

//this could be converted to enum using apache enums
//and the parameters can be loaded from properties file
//but, for now we keep this static configuration
public class Parameters<T> {

	private static final String s = File.separator;
	
	public static final Parameters<String> RESOURCE_PATH =  new Parameters<String>("ii"+s+"edu"+s+"mk"+s+"resources"+s);
	public static final Parameters<String> APP_NAME =  new Parameters<String>("CCS");
	public static final Parameters<Dimension> SCREEN_RESOLUTION = new Parameters<Dimension>(new Dimension(800, 600));
	
	private T value;
	private Parameters(T value) {
		setValue(value);
	}
	
	public void setValue(T value){
		this.value = value;
	}
	
	public T getValue(){
		return value;
	}
}
