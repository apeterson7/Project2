package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class Practice {

	public static void main(String[] args) throws IOException {
		
		
		TestNG testng = new TestNG();
		List<String> suites = new ArrayList<String>();
		suites.add("testng.xml");
		testng.setTestSuites(suites);
		testng.run();
		/*
		Properties props = new Properties();
		FileInputStream in; 
		in = new FileInputStream("src/main/resources/connection.properties");
		props.load(in);
		
		System.out.println(props.getProperty("username"));
		System.out.println(props.getProperty("password"));
		System.out.println(props.getProperty("name3"));
		*/

	}
}
