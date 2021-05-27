package myproject.data;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Factory;

import myproject.test.TestCase;

public class TestCaseFactory {
	@Factory
	public Object[] factoryMethod() {
		
		List<Object> objectsList = new ArrayList<Object>();
		Object[] obj ;
		//File folder = new File("D:\\Being a Techie\\selenium-maven\\src\\test\\java\\myproject\\files") ;
		String project_path = System.getProperty("user.dir") ;
		List<String[]> fromFile=DataHandler.readData(project_path+"\\src\\test\\java\\myproject\\files");
	
		
		for(String[] line : fromFile) {
			TestCase data = new TestCase();
			data.setFirst_field(line[0]);
			data.setSecond_field(line[1]);
			data.setOrder(fromFile.indexOf(line));
			objectsList.add(data) ;
		}
		obj = objectsList.toArray() ;
		return obj ;
		
	}
}
