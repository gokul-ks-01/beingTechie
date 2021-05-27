package myproject.data;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
	
	public static String getPropertyValue(String property) throws IOException {
		
		String project_path = System.getProperty("user.dir") ;
		FileReader reader=new FileReader(project_path+"\\properties\\Testing.properties"); 
		Properties p=new Properties();  
	    p.load(reader);  
	    String propertyValue = p.getProperty(property);
		return propertyValue;
	}

}
