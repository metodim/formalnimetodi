package ii.edu.mk.io;

import ii.edu.mk.core.BaseTest;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * 
 * @author Vladimir Carevski
 */
public class TestAldebaranIO extends BaseTest{

	@Test
	public void testAldebaranIO() throws IOException{
		File fileIn = getTestResourceFile("alt_bit.aut");
		File fileOut = getTestResourceFile("alt_bit_out.aut");
		
		AldebaranFile alFile = AldebaranIOUtils.readFile(fileIn);
		AldebaranIOUtils.writeFile(alFile, fileOut);
		
	}
	
	
	
}
