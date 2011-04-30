package ii.edu.mk.io;

import ii.edu.mk.io.AldebaranFile.AldebaranFileLine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class AldebaranIOUtils {

	
	public static AldebaranFile readFile(File file) throws IOException{
		AldebaranFile aldebaranFile = new AldebaranFile();
		
		BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		String line = bufReader.readLine(); //aldebaran descriptor
		aldebaranFile.readDescriptor(line);
		while((line = bufReader.readLine()) != null){
			aldebaranFile.readLine(line);
		}
		
		bufReader.close();
		return aldebaranFile;
	}
	
	public static void writeFile(AldebaranFile aldebaranFile, File file) throws IOException{
		if(!file.canWrite())
			throw new IllegalArgumentException("Can not write in this file");
		
		BufferedWriter bufWriter = new BufferedWriter(new FileWriter(file, false));
		
		bufWriter.write(aldebaranFile.getDescriptor());
		for(AldebaranFileLine line : aldebaranFile.getLines()){
			bufWriter.newLine();
			bufWriter.write(line.toString());
		}
		bufWriter.flush();
		bufWriter.close();
	}
	
}
