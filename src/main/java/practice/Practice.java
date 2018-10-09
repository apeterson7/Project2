package practice;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class Practice {

	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		List<String> suites = new ArrayList<String>();
		suites.add("testng.xml");
		testng.setTestSuites(suites);
		testng.run();
	}
}
