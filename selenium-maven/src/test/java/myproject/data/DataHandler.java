package myproject.data;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;  
public class DataHandler {   
	
	public static List<String[]> readData(String folderPath) {
		CSVReader reader = null;
		List<String[]> lineArray = new ArrayList<String[]>();
		try {
			
			File folder = new File(folderPath) ;
			File[] fileList = folder.listFiles();
			int numberOfFiles = fileList.length ;
			String[] nextLine;
			for(int i=0;i<numberOfFiles;i++) {
				reader = new CSVReader(new FileReader(fileList[i].getAbsolutePath()));
				while ((nextLine = reader.readNext()) != null) {
					lineArray.add(nextLine);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lineArray;
	}
}  