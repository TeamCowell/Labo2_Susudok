import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class FileReader {
	
	private String path = "";
	
	public FileReader(String path){
		this.path = path;
	}
	
	public int[][] readSudFile() throws IOException{
		int[][] array = new int[9][9];

		
		byte[] buffer = new byte[2];
		InputStream str = new FileInputStream(path);
		String line = "";
	    while (str.read(buffer) != -1) {
	    	line += new String(buffer);
	    }
	    for(int i=0; i<9; i++){
	    	for(int j=0; j<9; j++){
	    		array[i][j] = Character.getNumericValue(line.charAt(j+11*i));
	    	}
	    }
	    System.out.println(Arrays.deepToString(array));
		
		str.close();
		return array;
	}

}
